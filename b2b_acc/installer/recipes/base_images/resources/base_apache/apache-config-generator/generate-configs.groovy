import groovy.json.JsonException
import groovy.json.JsonSlurper
import java.security.MessageDigest;

import java.nio.file.Files
import java.nio.file.Paths



//  Variables
def slurper = new JsonSlurper()
def httpdHome = System.getenv("HTTPD_HOME") ?: "/etc/httpd"
def docHome = System.getenv("HTTPD_DOC_HOME") ?: "/var/www/html/"
def sslHome = System.getenv("SSL_CONF_DIR")
def startupDir = "/opt/startup"
def projectRoot = new File(getClass().protectionDomain.codeSource.location.path).parent

// Handle inputs  and fall back to defaults
if(args && args[0] && new File(args[0]).exists()) {
    println "Custom webserver.json provided, using custom configurations"
    webserver_json = args[0]
} else {
    println "No webserver.json provided, using default configurations"
    webserver_json = "${projectRoot}/webserver.json"
} 

try {
  webserverConfigs = slurper.parse(new File(webserver_json))
}  catch (JsonException e) {
  println "Invalid webserver.json format\n${e.getMessage()}"
  return
}

// Files
def virtualHostTemplate = new groovy.text.StreamingTemplateEngine().createTemplate(new File("${projectRoot}/templates/extra-vhost.conf.tmpl"))
def maintenanceTemplate = new groovy.text.StreamingTemplateEngine().createTemplate(new File("${projectRoot}/templates/maintenance.html.tmpl"))
new File("${projectRoot}/outputConfigs/hybris.d").mkdirs()
def vhostConf = new File("${projectRoot}/outputConfigs/hybris.d/vhosts.conf")

def maintanencePage = { title, content, outputFileName ->
    new File("${projectRoot}/outputConfigs/hybris.d/$outputFileName")
    def binding = [:]
    binding.put("maintenancepage_title", title)
    binding.put("maintenancepage_content", content)
    new File("${projectRoot}/outputConfigs/hybris.d/$outputFileName") << maintenanceTemplate.make(binding.withDefault{ false })
}

def generateAuthentication = { authentication, outputFileName ->
  def File accessFile = new File("${projectRoot}/outputConfigs/hybris.d/${outputFileName}")
  authentication.each { accessFile.append("${generateMD5(it.key, it.value)}\n") }
}

def generateMD5(String s, String b) {
   "htpasswd -bn  $s $b".execute().text
}

// Iterate over all the vhosts provided to have configs for each domain
webserverConfigs.webserver_apache_vhosts.each {
  // Maintenance Page
  new File("${projectRoot}/outputConfigs/hybris.d/$it.webserver_apache_domain/maintenance").mkdirs()
 
  def customMaintenancePage = new File("${startupDir}/maintenance/$it.webserver_apache_domain/maintenance")
  if (customMaintenancePage.exists()) {
    println "Custom maintenance page provided for ${it.webserver_apache_domain}"
    new AntBuilder().copy(toDir: "${projectRoot}/outputConfigs/hybris.d/$it.webserver_apache_domain/maintenance"){ fileset(dir: customMaintenancePage.getAbsolutePath())}
  } else {
    maintanencePage(it.webserver_apache_maintenancepage_title, it.webserver_apache_maintenancepage_content, "$it.webserver_apache_domain/maintenance/index.html")
  }
  
  if(new File("${sslHome}/${it.webserver_apache_domain}").exists()) {
    it.put("ssl_home", "${it.webserver_apache_domain}/")
  } else {
    it.put("ssl_home", "")
  }

  // HTTP Authentication 
  if(it.webserver_apache_authentication_credential)
  {
    generateAuthentication(it.webserver_apache_authentication_credential, "$it.webserver_apache_domain/authentication-users")
  }
  
  vhostConf << virtualHostTemplate.make(it.withDefault{ false })
}

def configs = new File("${projectRoot}/outputConfigs/hybris.d")
def apacheConfigDir = new File("${httpdHome}/conf.d")
new File(apacheConfigDir, configs.getName()).exists() ? new File(apacheConfigDir, configs.getName()).deleteDir() : ""
println (configs.renameTo(new File(apacheConfigDir, configs.getName())) ? "Successfully configured" : "Configuration unable to be applied to apache")

