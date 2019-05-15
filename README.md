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
