#!/bin/bash

service="sudo /sbin/service"

for name in chef-server-webui chef-server chef-expander chef-solr thrift-service tomcat vhm httpd rabbitmq-server postgresql couchdb; do
  if [ "${name}" == "vhm" ]; then
    sh /opt/serengeti/sbin/vhm-stop.sh
    continue
  fi

  $service $name stop

  #kill tomcat if it cannot be stopped by service
  if [ "${name}" == "tomcat" ] 
  then
    pidlist=`ps -ef | grep tomcat | grep -v "grep"| awk '{print $2}'`
    if [ "$pidlist" != "" ]
    then
      for pid in ${pidlist}
      {
        kill -9 $pid
      }
    fi
  fi

  if [ $? -ne 0 ]; then
    echo "Cannot stop service $name, please restart it mannually."
  fi
done
