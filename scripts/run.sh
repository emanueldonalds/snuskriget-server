#!/bin/bash
appName="snuskriget-server"
appVersion="1.0.0";

parent_path=$( cd "$(dirname "${BASH_SOURCE[0]}")" ; pwd -P )
echo $parent_path
cd "$parent_path"

java -jar ./../build/libs/$appName-$appVersion.jar </dev/null &>/dev/null &
