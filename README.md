# hybris

To be able to take the SAP Commerce tutorials please click [here](https://help.sap.com/viewer/3fb5dcdfe37f40edbac7098ed40442c0/1811/en-US/be491744fa904e058e4da45922c02e4c.html)

---

## Installation
- [Install SAP Commerce 123 Interactive](https://help.sap.com/viewer/3fb5dcdfe37f40edbac7098ed40442c0/1811/en-US/bb7025b1150a43449f78fb6c9a41da4a.html)
  Verify the interactive running webpage at: http://localhost:8080
- Do not forget to (download)[https://help.sap.com/viewer/3fb5dcdfe37f40edbac7098ed40442c0/1811/en-US/a1ef894ac89545e79c470c726b487d13.html] and add the hybris123.zip file to the installation directory. Then, unzip it and finally compile it with `mvn clean package -DskipTests`

## Set up the git repository
- Install git large file system (for files bigger than 100 mb)
  - `brew install git-lfs`
  - `git-lfs install`
  - Track large files:
    - Start tracking a new file: `git lfs track '*.extension'`
    - List tracked files: `git lfs track`

### Installer Recipes

Simplify the installation and setup of SAP Commerce for *development* purposes. Do not use the installer to run one recipe after another on the same SAP Commerce setup. The installer does not uninstall recipes, and does not restore your SAP Commerce file system to its original settings. To install another recipe, use the original SAP Commerce files and directories.

Follow the next steps to Run a fresh SAP Commerce using a recipe:

```
cd installer; ./install.sh -r platform_only setup
cd installer; ./install.sh -r platform_only initialize 
cd hybris/bin/platform; ./hybrisserver.sh start
```

The setup phase creates temporary directories.
The initialize phase, generates the database schema and the type system, and imports any mandatory system data.

### Extensions

An extension is an encapsulated piece of SAP Commerce functionality, that can contain business logic, type definitions, a web application, and back-office configuration functionality. Depending on your business needs, your solution will have a varying number of extensions, all wired into the core SAP Commerce platform via the Spring dependency injection model.

SAP Commerce ships with a number of extension templates, and an ant-based tool (called extgen) for generating new extensions based upon these templates. In this and subsequent sections, you extend SAP Commerce by adding and developing your own custom extension.

To build a new extension: 

  - navigate to {HYBRIS_DIR}/bin/platform. Then type `ant extgen` and complete the information as required.
  - add the new extension to the `localextensions.xml` and comment out all the others.
  - run command `ant clean all`

For more information: https://help.sap.com/viewer/3fb5dcdfe37f40edbac7098ed40442c0/1811/en-US/438db70eb0234697976eeceaba6d0394.html

### The localextensions.xml file

The localextensions.xml file contains the list of extensions your specific SAP Commerce configuration includes at compile- and run-time.

When you first build SAP Commerce, the localextensions.xml file lists only the essential extensions. As you decide which extensions you need or want to use, add them to this file. In this procedure, you notify SAP Commerce of the new concerttours extension by adding it to the localextensions.xml file.

### Require other extensions

An extension is configured by the extensioninfo.xml file.

It defines the following:

  - A list of extensions required for current extension. If the required extension does not exist in your installation, then the build of SAP Commerce fails.
  - A list of available extension modules with their configuration:
    - core extension module
    - web extension module: Among other things, you can define webroot of the Web application.

### Data models

The data model underlying SAP Commerce is defined in XML files. New data types for extensions, called item types, are defined in <extension-name>-items.xml files.

SAP Commerce refers to data types as itemtypes, each defined in an itemtype XML element. You define a new item type by adding a new itemType element to the<extension-name>-items.xml file. Similarly, SAP Commerce refers to a one-to-many and many-to-many relationship between itemtypes as a relation, and you define new relations by adding a relation XML element to the <extension-name>-items.xml file.

At build time and database-initialization time, the platform combines all the XML declarations from the extensions being used, and generates Java classes and a database schema.

**items.xml files**

_\<itemtype\>_
  - autocreate (true/false): Lets SAP Commerce create a new database entry for this type at initialization/update process. 
  - generate (true/false): Results in Java class files being generated for this type

  * _NOTE:_ After updating an ItemType, update the system with: `ant updatesystem`

### Database design

SAP Commerce stores data in a RDBMS and several third-party databases are supported.

When you define a new data model, you must specify how that model is to be persisted in the database. Specifically, whether each new item type should be persisted in its own database table or in a parent table. When you define new item types, you can include a deployment XML attribute to specify the name of a new table specific to that type. If you do not include the deployment XML attribute in a new item type, SAP Commerce persists that item in the table used by the parent of the new type. This si genarally what we want, because it makes it easy to retrieve al set of items and no database table joins are required.

In contrast, if an item is not extending another item and the deployment XML clause is not defined, items will be stored in the table specified by the root item type called GenericItem. All types extend GenericItem unless specified otherwise. This is almost certainly not what you want, so when you are not specifically extending another item type, you should always include a deployment clause.

To open the default hsql DatabaseManager to visualize your tables, run under `/hybris`:
`java -cp ./bin/platform/lib/dbdriver/hsqldb*.jar org.hsqldb.util.DatabaseManager --url jdbc:hsqldb:file:./data/hsqldb/mydb &`

To close de DatabaseManager, type: `pkill -f "DatabaseManager"`

### ImpEx

SAP Commerce ships with a powerful text-based import and export functionality called ImpEx.

ImpEx files are essentially comma-separated files (CSVs) that allow for compact, human-readable, import and export of data to and from SAP Commerce. They can be manually executed through the SAP Commerce Administration Console, or automatically executed every time you initialize the system by saving the ImpEx file according to a simple convention, and in a specific location.

The SAP Commerce Administration Console provides an interface, in the Impex Import tab of the Console, through which you can manually import small amounts of ImpEx data.

### Essential and Project Data by Convention

You can prepare ImpEx files containing essential and project data that the system imports on initialization. This functionality follows the Convention over Configuration principle (CoC).

Using ImpEx to import data through the SAP Commerce Administration Console (Administration Console) is useful for adhoc imports, but not for repeatedly loading large amounts of ImpEx content every time you initialize or update the database. To automatically load this data, you can place your ImpEx in text files in the /resources/impex directory of your extension. A naming convention then ensures that SAP Commerce automatically loads them as part of the initialization or update process.

Impex files fall into two categories: those describing essential data, and those describing project or product data.

*Essential data ImpEx file*

Contains fundamental reference data that is required by your extension. Essential data is always imported when you initialize the platform with your extension. Essential data ImpEx files have names in the form essentialdata*.impex.

*Project data ImpEx file*

Contains data that is optional your extension, such as sample data. Project data is included only when you check the project data checkbox for your extension in the Administration Console during initialization. Project data ImpEx files have names in the form projectdata*.impex.

If there are multiple files found that fit the naming convention, SAP Commerce loads and processes them in an unspecified order. If the order is important, one simple solution is to create a single file meeting the naming convention. You then use the ImpEx include feature to include the content from the other files in the required order, and rename the included files so they no longer fit the naming convention.

In this example, the ImpEx files are deliberately designed to separate all the content for each tour into a separate file, and use INSERT_UPDATE commands. Therefore, if there are many tours and concerts to import, then the order in which the files are processed is not important.

### Essential and Project Data by Code

You can hook into the system initialization and update process to load project data during platform initialization.

After some consideration, you decide that band data is not really essential data and should be loaded as project data. Essential data is reserved for data that the system cannot work without. For this reason, move your band data out of essential data and set it up as project data instead. While the results are not exciting, all your code still works if there are no bands stored in the database.

As your project data may grow significantly and become more complex, you can take the sophisticated approach of hooking into the initialization and update process.

Your simple Java class uses the ImpEx service layer API to explicitly load your two ImpEx files. The main work is done in the impexImport method. You set up an ImportConfig object with various import options, including the name of the file you want to import. You then supply it as a parameter to the importData call. The system checks the resulting ImportResult for errors.

The code also demonstrates the logging facilities that are built in to the platform.

### Essential and Project Data by Convention and Code

SAP Commerce looks for and loads data from ImpEx files that follow a specific naming convention. This behaviour supports the convention over configuration software design paradigm.

Any ImpEx files that follow the SAP Commerce naming convention are automatically loaded whenever you initialize the system. You can use this to set up essential data that your extension needs to run. You can also optionally provide some initial data such as sample data, or initial values in a categories table for example, that the system also loads for convenience. The latter data type is known as project data.

The naming convention for these two data types is as follows:

essentialdata-*.impex
projectdata-*.impex
In each case, the * can be any name you choose, but it is convential to use your project name or data type.

### The service layer

When implementing new business logic, you separate the business code into java classes called services. Each service implements a specific, well-defined requirement.

Services form part of the ServiceLayer. This layer is a logical tier between the client and persistence layer. Each service has its own java interface that lists the public methods that can be called by clients and other services.

A service may contain all required business logic, but more commonly will delegate to one or more of the following:

Other services providing part of the behavior required
Strategy objects that provide swappable behavior for different requirements, e.g. different cart calculation algorithms
Data access objects that handle locating and retrieving data items from the database
These other services, strategy objects and data access objects are also defined as Spring beans, with respective interfaces and implementations.

### Integration tests

Integration tests are essential for demonstrating that your new functionality works as expected. They notify you when you break existing behavior, and can therefore help reduce bugs.

### Unit tests

You can simulate dependencies to execute unit tests that run independently of the SAP Commerce platform.

An integration test demonstrates that you have successfully achieved the expected behavior of classes that implement the BandService interface. However it is not truly testing the expected functionality of your particular DefaultBandService class. To do that you should mock up the dependencies, the BandDAO in this case, using Mockito in a new unit test class called DefaultBandServiceUnitTest. As this simulates a real DAO, the test requires no access to the SAP Commerce persistence layer, and therefore does not need to extend ServicelayerTransactionalTest. Instead it is a simple POJO and will run very quickly.

You will test that the expected calls are made from the BandService to the BandDAO interface. No implementation of the BandDAO is needed when simulating the BandDAO interface.

### The facade layer

A facade is an abstraction layer that provides a simplified interface to the underlying implementation.

In previous sections, you saw that SAP Commerce generates Java model classes that represent the different types of item that are stored in the database. These model classes are what you pass as arguments to the different Java services in the SAP Commerce service layer. Nevertheless, there are occasions when the model classes become unwieldy:

  - When you need a simpler or more convenient format for some of the data to display in JSPs
  - When you need a serializable set of objects to send to another system
  - When you want to prevent client code from modifying attributes in a model class object directly

In these cases, you need a simpler representation of the data in the model classes. This representation is the purpose of the Data Transfer Object. In addition, if there is a common sequence of method calls that a client must make against a service object, it makes sense to combine the sequence into one call. You make these simplified calls with a facade object.

Facade classes help simplify the calls made to your service classes. They use simpler plain old java objects (POJOs) as argument and result objects, instead of SAP Commerce model classes. In this step, you create a new BandFacade class.

### The front end

Once you have a model and business logic in place, you can develop a suitable front-end web application. When building your front end, use the Spring MVC framework to separate the model, the view, and the controller parts.

SAP Commerce provides a range of Accelerator storefronts. The Accelerators give you basic building blocks that you can use for developing sophisticated and responsive storefronts within specific commerce domains. But to illustrate the basics of how stores are constructed, you focus here on two aspects.

**The Controller Class**
  - The interface between the user action and the underlying model.

**JSP Pages**
  - Dynamic web pages for presenting data to the end user.

You have previously created the model aspect of your MVC architecture, now you create the view, the JSP pages, and the controller, the controller class.

### Dynamic attributes

Dynamic attributes enable you to add attributes to your model, and to create custom logic for them, without touching the model class itself. They provide a way to generate new data, and access it without calling a separate service to do so. Dynamic attributes are transient data that is not persisted to the database.

All the attributes you have defined so far for your Band items are simply stored and retrieved without any extra business logic involved. You use the getter and setter methods of the corresponding Java model class to access and modify them. However, you can also dynamically compute values for an item and expose those values through the getter and setter methods. There are many reasons you may wish to do so:

  - You may want to expose a value in a different set of units. For example, you may need to represent a point on a map as both polar and cartesian coordinates, a time in both 12 hour and 24 hour form, or a relative and absolute version of a directory path or URL.
  - You may want to calculate a value from several attributes of an item. For example, you may want to calculate the distance between two attributes that hold a location, add the values of a number of attributes together such as price, tax, and discount in an order item to provide a subtotal, or determine the age of a person from a date of birth attribute and the current date.

To provide the custom logic for a dynamic attribute of an item type, you need to provide read and write logic depending upon the requirements for that attribute. You cannot add that logic directly to the model classes because they are already generated, and anything you add would be overwritten and lost the next time you rebuilt the system. Instead, write a plain Java class that implements the DynamicAttributeHandler interface. This interface makes use of Java generics so that the actual class reflects both the attribute value type ( in this case java.lang.Long ) and the model class it works upon (in this case Concert). You then declare this handler class as a Spring bean.

For this trail you create a new attribute called Concerts.daysLeft that exposes the dynamically calculated number of days left before a concert is due to be held. This value can then be used for displaying a countdown to the concert date on a web page, for example.

The implementation of this new dynamic attribute has some key features:

  - The persistence type is set to dynamic
  - The persistence attributeHandler points to a bean that must handle the DynamicAttributeHandler interface
  - The write attribute is set to false, and therefore the attribute is read-only

### Web page update

Update the relevant parts of your extension to use the new dynamic attribute.

After introducing new item attributes, you want to apply them. In this case, you want to display the days left until a concert value in the tour details page. To do so, you need to update your TourFacade, TourDetails.jsp page, and the ConcertSummaryData class so that the calculated value of the dynamic attribute Concerts.daysLeft appears in the front end.

### Events and listeners

The Event System is a framework provided by the ServiceLayer that allows you to send and receive events within SAP Commerce.

You can set up components of your extension to publish events that are then received by registered listeners. Listeners are objects that are notified of events and perform business logic depending on the event that occured. Events can be published either locally or across a cluster of nodes. You can register new listeners as Spring beans in your Spring configuration XML file.

The platform defines and publishes events for a number of predefined types of event. These include the AfterItemCreationEvent type, items of which are published after any new data item is saved to the database. To process these AfterItemCreationEvent events, you provide a listener class and register it with the event framework.

For your concerttours extension, you want to generate items of news that you can potentially send out to registered subscribers through various channels. You want to create a new News item whenever a new band is signed. In your listener class, you override the onEvent method to specify the code you want to execute when this event occurs. In this case, you are checking to see if the new item is a band. If it is, you ask the platform model service to create and save a new news item.

### Custom events and interceptors

Interceptors intercept model object lifecycle transitions and, depending on the conditions of that transition, may publish an event when they do so.

Model classes represent SAP Commerce items. Each model contains all item attributes from all extensions, which unifies access to the data for an item.

An interceptor addresses a particular step in the life cycle of a model. When the life cycle reaches a certain step, you can activate a corresponding interceptor. An interceptor can modify the model, raise an exception to interrupt the current step, or publish an event if the model matches certain criteria. For example, you could check that an attribute contains certain values before saving the model.

### Cluster-aware events

SAP Commerce supports cluster-aware events. Cluster-aware events enable the processing of events in separate threads, or on particular nodes of a cluster.

By default, SAP Commerce processes all events synchronously. But synchronous messaging has some disadvantages:

The main thread waits until all events are processed. For example, a band is not saved until a corresponding news item is created.
A slow listener can cause the system to throw a timeout exception.
In such circumstances, it is preferable to process events on a separate thread. In addition, when SAP Commerce is deployed on a cluster in a production environment, a system administrator may want event processing to occur on particular nodes. You can achieve both of these things by enabling cluster-aware events.

### Cron jobs

SAP Commerce provides a means to set up regular tasks. With these tasks, or cron jobs, you can repeatedly perform complex business logic at particular times and intervals.

You may want to perform an inventory every Sunday at midnight, for example, or notify the web administrator of the peak loads on the servers every hour. You can achieve this through a combination of dedicated classes for the business logic, and the embedded cron job management functionality of SAP Commerce.

The first step in implementing a cron job is to place your business logic in a class that extends AbstractJobPerformable. You then develop a new, simple service to provide access to the news items, and encapsulate that business logic in a job class. The steps are similar to those you took to create the band service, and serve to reinforce this pattern.

The SAP Commerce platform ships with a useful email utility class, MailUtils, that simplifies the sending of e-mails with commons mail API. You make use of the MailUtils class to create an e-mail message object populated with values from the local.properties file in your config directory.

## Triggers

With your business logic successfully factored into a job class, you can trigger its execution with the use of a cron job.

A cron job consists of the job class containing the business logic, and a trigger to start the job at regular intervals. The first step in setting up a new cron job is to notify SAP Commerce of your new class by creating your essential data. During the creation of essential data, a ServicelayerJob item is created for every Spring definition that has a class implementing the JobPerformable interface. The code attribute of each of the new job item is set to the name of the relevant Spring bean.

Once a ServicelayerJob item is created, you can create a cron job to wrap the ServicelayerJob, and define a trigger to that starts it.

A cron expression is a string comprised of 6 or 7 fields separated by white space. Fields can contain any of the allowed values, along with various combinations of allowed special characters for that field.

The first cron job you create for your extension runs on a daily basis, and sends out summaries of new items by email to a specific email address or distribution list. Then you create a second cron job using a scripting language instead of a Java class. Using a scripting language, you can add cron jobs to a system without having to rebuild and redeploy it.

### Groovy

You can use the Groovy scripting language to write jobs for execution.

### Backoffice Administration Cockpit

Backoffice Administration Cockpit is a user-friendly, browser-based, user interface for viewing, creating, and manipulating data within SAP Commerce.

Backoffice Administration Cockpit consists of widgets, each with a specific function. This allows you to manage a range of different data types. The primary data used by SAP Commerce is available in the Administration perspective. You can select individual categories from the explorer tree, a menu listing in the left hand side of the main window. From here, you can view, list, enter, and edit catalog and product data, user data including roles and permissions, price settings, internationalization, or basic system configuration data.

For the concerttours extension, Backoffice Administration Cockpit is useful for viewing and editing band and tour data in a user-friendly way.

### Localization

Localization is intended to adapt SAP Commerce to multiple languages.

Localization is built into SAP Commerce Platform from the ground up, not bolted-on as an after thought. As a result, you can declare attributes and relations of item types as localized in an extension's *-items.xml file, and the system automatically provides for multiple values for different locales. Even the type system names themselves can be localized so that when item type and attribute names appear in user interfaces, they can be in the user's chosen language.

When the SAP build system encounters the localized keyword, instead of a single valued attribute, it creates a map of values keyed by language for that attribute, and generates an equivalent construct in the database.

Impex has a built-in syntax for specifying values for localized values, and it is often more manageable to separate content across impex files by language. While it is not necessary to use separate files for language-specific content, it usually makes it much easier to understand and manage. Particularly, it makes adding and removing the content for a specific language easier.

In the hybris123 integration tests, you used the model service to create new instances of bands, concerts, and others. The model service handles the provision of a locale to use when working with localized attributes. Unfortunately, when it comes to unit tests you don't have the context provided by the model service. As a result, when you call the usual getter or setter of a localized attribute, the model object doesn't know which language to map the value to. If you are only accessing localized attributes in your test code, you can fix this problem by using a getter and setter that specifies the locale that you want used as an extra parameter.

If the simple accessors are being called in the code that you are testing, there is no way to provide a LocaleProvider for them to use. As a result, you can no longer test that code in a unit test. You have to fall back to using integration tests.

If for example you replace the calls to getHistory() and setHistory() in the test DefaultBandFacadeUnitTest methods with getHistory(Locale.ENGLISH) and setHistory(BAND_HISTORY, Locale.ENGLISH), that test will still fail because the code that you are testing in the actual DefaultBandFacade class calls the simple getHistory() accessor.

The only way you can make this test pass is to have the code you are testing check if you are running outside the SAP Commerce Server context and modify its behaviour to cope with that. That makes no sense, so unfortunately you have to stop using this unit test and rely on the slower integration test instead.

### Localization in Backoffice Administration Cockpit

You can define localized values for item type attributes directly in the Backoffice Administration Cockpit.

### Validation

The SAP Commerce data validation framework ensures clean, correct, and useful data. The validation framework is based on the Java validation specification, JSR 303. It offers an easy and extensible way to validate data before it is passed on to the persistence layer.

The data validation framework has several goals:

  - To offer a framework for defining data validation constraints in easy and intuitive way
  - To validate data before it is saved
  - To notify about any validation violations should they occur

Validation logic may be triggered in the following ways:

  - Implicitly with the ValidationInterceptor that hooks into calls to the save method in a model
  - Explicitly by manually calling the validate method of the ValidationService, and passing in a SAP Commerce model or POJO to be validated

When validation violations are found, they are presented to the caller for a resolution. The validation framework does not extend to performing client side validation. Validation happens on the server side only.

The main components of data validation constraints are:

  - ValidationService: Manages validation constraints, and validates data
  - Backoffice Administration Cockpit: Provides a front-end for managing instantiated validation constraint types
  - Cockpit integration: Provides users with validation feedback in cockpits

For validation to work, you define constraints. In the procedure that follows you define validation constraints in the Items.xml file, but there are more ways to define constraints. You can use an ImpEx file, which allows you to automate the process and quickly add more constraints. ImpEx is an ideal way to work between multiple platforms. You can also define constraints in Backoffice Administration Cockpit. In this way, you can update validation constraints manually and at runtime.

### Validation constraints in backoffice

You can create and define validation constraints in the SAP Commerce Backoffice Administration Cockpit.

You can define validation constraints in ImpEx files, making it easy to reload constraints after initializing the database.

Validation constraints are persisted to the database. If you frequently reinitialize the database during the development and testing phase of your project, there is a danger that you could erase any stored constraints. To ease the effort of restoring validation constraints, it is a good idea to define and load them using ImpEx files.

### Validation Constraints in ImpEx

You can define validation constraints in ImpEx files, making it easy to reload constraints after initializing the database.

Validation constraints are persisted to the database. If you frequently reinitialize the database during the development and testing phase of your project, there is a danger that you could erase any stored constraints. To ease the effort of restoring validation constraints, it is a good idea to define and load them using ImpEx files.

### Custom validation constraints

Although the validation framework provides all constraints from the JSR 303 specification, sometimes you need other constraint types that are specific to your project.

In our case, too often a band's history is set to a piece of placeholder text instead of the meaningful, genuine background of the band. Create a constraint that prevents this occurrence by looking for text that is missing, or starts with "lorem ipsum".

The new constraint type extends AttributeConstraint because you are validating the values of attributes, not of the type as a whole. If you want to create constraints that apply to the whole of an item, extend TypeConstraint instead. The only attribute holds a reference to the Java annotation class that defines our constraint as a Java annotation.

The @Constraint annotation specifies a NotLoremIpsumValidator class that provides the actual logic for checking the constraint. The constraint checks that if the value is not null or empty, and that it does not start with the phrase lorem ipsum. Of course, you can get more sophisticated but this good enough for the purposes of the exercise.

Note that you can see the other mapping properties for the built-in constraint types in the file ext/validation/project.properties in the platform project.

### Integration Test for the Custom Constraint

Become familiar with how to use the SAP Commerce validation service in code.

Write a test that checks whether the constraint is working as expected. Use ImpEx to load the constraint into the database, and then the validation service to load it from the database into the validation engine.

### Properties files

SAP Commerce relies on two essential configuration files: project.properties and local.properties. Project properties are the SAP Commerce defaults, while local properties is where you may define your own configuration for your extension.

You can set values in different properties files. Each file has a different priority and its values can override the values of another file with lower priority. The order of priority from hight to low is:

  - The local.properties file is a working copy of the project.properties file, located in the <HYBRIS_CONFIG_DIR> directory. It allows you to override default settings from the project.properties file. Use the local.properties file to set values for configuration properties that you need to configure for your project.
  - The extension-specific project.properties file is located in the <HYBRIS_BIN_DIR>/<EXTENSION_DIR>. It defines the values used for the extension.
  - The global project.properties file is located in the <HYBRIS_BIN_DIR>/platform directory, and provides factory default settings. It is not recommended to edit this file.
