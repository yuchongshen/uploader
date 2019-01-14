#!/bin/bash
kill -9 `ps -ef |grep java |grep uploader-v1.0.jar |awk '{print $2}' `
java -jar uploader-v1.0.jar -port 8888 -uploadpath .