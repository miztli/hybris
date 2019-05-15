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
