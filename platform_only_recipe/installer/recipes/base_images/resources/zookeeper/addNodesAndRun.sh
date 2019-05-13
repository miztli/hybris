#!/bin/bash

echo $MYID is my id

mkdir /var/zookeeper
echo $MYID > /var/zookeeper/myid
/opt/zookeeper/bin/zkServer.sh start-foreground