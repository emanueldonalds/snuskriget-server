#!/bin/bash
parent_path=$( cd "$(dirname "${BASH_SOURCE[0]}")" ; pwd -P )
cd "$parent_path"
nohup java -jar "./../build/libs/snuskriget-server-1.0.0.jar"