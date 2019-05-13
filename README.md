# hybris

To be able to take the SAP Commerce tutorials please click [here](https://help.sap.com/viewer/3fb5dcdfe37f40edbac7098ed40442c0/1811/en-US/be491744fa904e058e4da45922c02e4c.html)

---

## Installation
- [Install SAP Commerce 123 Interactive](https://help.sap.com/viewer/3fb5dcdfe37f40edbac7098ed40442c0/1811/en-US/bb7025b1150a43449f78fb6c9a41da4a.html)
  Verify the interactive running webpage at: http://localhost:8080

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

