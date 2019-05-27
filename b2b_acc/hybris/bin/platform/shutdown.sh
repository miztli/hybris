#!/bin/sh

DIR=`dirname $0`
java -cp ${DIR}/bootstrap/bin/ybootstrap.jar de.hybris.platform.shutdown.InvokeShutdown
