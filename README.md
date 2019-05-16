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

### Extensions

An extension is an encapsulated piece of SAP Commerce functionality, that can contain business logic, type definitions, a web application, and back-office configuration functionality. Depending on your business needs, your solution will have a varying number of extensions, all wired into the core SAP Commerce platform via the Spring dependency injection model.

SAP Commerce ships with a number of extension templates, and an ant-based tool (called extgen) for generating new extensions based upon these templates. In this and subsequent sections, you extend SAP Commerce by adding and developing your own custom extension.

### The localextensions.xml file

The localextensions.xml file contains the list of extensions your specific SAP Commerce configuration includes at compile- and run-time.

When you first build SAP Commerce, the localextensions.xml file lists only the essential extensions. As you decide which extensions you need or want to use, add them to this file. In this procedure, you notify SAP Commerce of the new concerttours extension by adding it to the localextensions.xml file.

### Data models

The data model underlying SAP Commerce is defined in XML files. New data types for extensions, called item types, are defined in <extension-name>-items.xml files.

SAP Commerce refers to data types as itemtypes, each defined in an itemtype XML element. You define a new item type by adding a new itemType element to the<extension-name>-items.xml file. Similarly, SAP Commerce refers to a one-to-many and many-to-many relationship between itemtypes as a relation, and you define new relations by adding a relation XML element to the <extension-name>-items.xml file.

At build time and database-initialization time, the platform combines all the XML declarations from the extensions being used, and generates Java classes and a database schema.

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


