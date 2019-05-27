## hybris installer

With the **Installer** you can install different **scenarios** of the Commerce Suite on your local machine, e.g.

* B2C Accelerator
* B2B Accelerator with OMS
* B2B Accelerator with Data Hub and SAP ERP
* OMS standalone
* etc

The scenarios are defined by so-called **recipes**.
 
Each recipe contains tasks:

* setup - sets up the Commerce Suite with a defined set of extensions, necessary configurations settings, etc
* buildSystem - builds Commerce Suite
* initialize - initializes the Commerce Suite
* initializeJunit - initialzies the Commerce Suite's JUnit tenant
* start - starts the hybris Server
* startInBackground - starts the hybris Server in background mode
* stopInBackground - stops the hybris Server in background mode
* testJunit - runs Junit tests
* testInitialize - runs tests which analyse initialization process (usually should be dependend on initialize task)
* testServer - runs test which analyse whether web apps are starting correctly

Dockerized recipes contains tasks:

* createImagesStructure - creates images structure for Docker
* buildImages - builds Docker images based on prepared structure
* pushImages - pushes Docker images to external Docker registry (provided by 'pushToServer closure')

Additionally each recipe contains four _meta-tasks_ which combines some of the above tasks in particular order:

* perform - performs setup, build, initialize and start - in this order
* performTestJunit - Performs setup, build, initializeJunit, testJunit - in this order
* performTestInitialize - Performs setup, build, initialize, testInitialize - in this order
* performTestServer - Performs setup, build, initialize, startInBackground, testServer - in this order
 
## How do I execute my recipe?

You exececute the recipes with the script `install.sh` (Unix/Mac) or `install.bat` (Windows), respecitively. Recipes are located in the `recipes` folder. Use the `-r` switch to specify the recipe you want to use (as explained below).

To show the usage of the `install.sh` script type:

    ./install.sh -h

To run the default `setup` task for a given recipe type:

    ./install.sh -r my_recipe

To run a particular task for a give recipe type:

    ./install.sh -r my_recipe my_special_task

To list all available recipes type:

    ./install.sh -l

To list all tasks for a given recipe type:

    ./install.sh -t my_recipe


# Custom properties

If you need to override the configuration properties provided by a recipe, for instance database credentials, you don't need to edit recipe yourself. You can put a file named **custom.properties** in the **customconfig** folder in the installer home direrectory and this file will be picked up automatically and will override properties provided by a recipe.

For instance to provide your database settings your **custom.properties** could look like this:

    db.url=jdbc:mysql://localhost/yourDb?useConfigs=maxPerformance&characterEncoding=utf8
    db.driver=com.mysql.jdbc.Driver
    db.username=user
    db.password=pass
    mysql.optional.tabledefs=CHARSET=utf8 COLLATE=utf8_bin
    mysql.tabletype=InnoDB
    mysql.allow.fractional.seconds=true
