# Cheatsheet Hybris

### Install a new instance of SAP Commerce from a recipe

Using a clean installation (try to extract the contents of the .zip file). 

*NOTE: * Do not use the installer to run one recipe after another on the same SAP Commerce setup. The installer does not uninstall recipes, and does not restore your SAP Commerce file system to its original settings. To install another recipe, use the original SAP Commerce files and directories.

```
cd installer; ./install.sh -r platform_only setup
cd installer; ./install.sh -r platform_only initialize 
cd hybris/bin/platform; ./hybrisserver.sh start
```

