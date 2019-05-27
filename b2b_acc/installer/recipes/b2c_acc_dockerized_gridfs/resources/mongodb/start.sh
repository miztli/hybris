#!/bin/bash
set -e

if [ ${REPL_SET} == "" ]; then	
	echo "Starting mongo without replication mode"
	/usr/bin/mongod
else
	echo "Starting mongo with replication mode support"
	/usr/bin/mongod --replSet ${REPL_SET}
	#/opt/mongodb/init_replica_set.sh  - not working yet - needs to be executed manually inside container
fi

