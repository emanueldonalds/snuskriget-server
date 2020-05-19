#!/bin/bash
appName="snuskriget-server"
appVersion="1.0.0";

kill -9 $(lsof -t -i:9000)

PROCESS=$1
PIDS=`ps aux |grep [j]ava.*$appName.*jar | awk {'print $2'}`

if [ -z "$PIDS" ]; then
  echo "No instances of $appName is running..." 1>&2
else
  for PID in $PIDS; do
    echo "Killing $appName with PID:$PID."
    kill -9 $PID
  done
fi