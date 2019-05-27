#!/bin/sh
if [ -n "$JAVA_HOME" ] ; then
  SCRIPT_PATH=`dirname $0`
  chmod +x "${SCRIPT_PATH}/gradlew"
  version=$(java -version 2>&1 | awk -F '"' '/version/ {print $2}')
else
  echo Error: JAVA_HOME is not set, please set it in your environment.
  exit 255
fi
if [ -n "$version" ] ; then
  if [ "$version" \< "1.8" ]; then
    echo Wrong java version is set - "$version", Installer requires at least java 1.8
    exit 255
  fi
fi
export INSTALLER_WORKING_DIR="${SCRIPT_PATH}"
java -classpath "${SCRIPT_PATH}/libs/commons-cli-1.2.jar:${SCRIPT_PATH}/libs/commons-lang-2.6.jar:${SCRIPT_PATH}/libs/groovy-all-2.4.12.jar:${SCRIPT_PATH}/libs/installer-18.11.0-M11.jar" de.hybris.installer.CmdHandler "$@"

