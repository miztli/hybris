import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 
class GenerateConfigTest extends GroovyTestCase {
    File generateScript
    Binding binding
    GroovyShell shell
    PrintStream orig
    ByteArrayOutputStream out
    
    @Before
    void setUp() {
      generateScript = new File("${getScriptDir()}/generate-configs.groovy")
      binding = new Binding()
      shell = new GroovyShell(binding)

      // Redirect stdout 
      orig = System.out
      out = new ByteArrayOutputStream()
      System.setOut(new PrintStream(out))
    }

    @After
    void tearDown()
    {
      System.setOut(orig)
      new File("${getScriptDir()}/outputConfigs").exists() ? new File("${getScriptDir()}/outputConfigs").deleteDir() : ""
    }
    
    @Test
    void testGenerateValidConfig() {
      binding.args = ["../resources/valid.json"]
      shell.evaluate(generateScript)
      verifyFileStructure()

      String vhost = new File("${getScriptDir()}/outputConfigs/hybris.d/vhosts.conf").getText()
      
      assert vhost.contains("ServerName localhost"), "ServerName not set properly\n" 
      assert vhost.contains("RewriteCond %{SERVER_PORT} !^\${HTTPS_PORT}\$"), "force_https not applied\n"
      assert vhost.contains("ProxyPass /my-app balancer://mycluster/my-app"), "allowed applications not applied\n"
      assert vhost.contains("CustomLog logs/localhost-access.log common"), "CustomLogs not set correctly\n"
    }
       
    @Test
    void testDoNotGenerateInvalidConfig(){
      new File("${getScriptDir()}/outputConfigs").exists() ? new File("${getScriptDir()}/outputConfigs").deleteDir() : ""
      binding.args = ["../resources/invalid.json"]
      shell.evaluate(generateScript)
      assert out.toString().contains("Invalid webserver.json format"), "Invalid json format not failing\n"
      assert !new File("${getScriptDir()}/outputConfigs").exists(), "Output configurations should not be generated with malformatted json\n"
    } 
    
    def verifyFileStructure()
    {
      assert new File("${getScriptDir()}/outputConfigs").exists(), "Output configurations not generated\n"
      assert (new File("${getScriptDir()}/outputConfigs/hybris.d").exists()), "Output configurations not generated\n"
      assert (new File("${getScriptDir()}/outputConfigs/hybris.d/localhost").exists()), "localhost maintenance not generated\n"
      assert (new File("${getScriptDir()}/outputConfigs/hybris.d/localhost/index.html").exists()), "localhost maintenance not generated\n"
      assert (new File("${getScriptDir()}/outputConfigs/hybris.d/vhosts.conf").exists()), "Output configurations not generated\n"
    }
    
    def getScriptDir() {
      "../.."
    }
}