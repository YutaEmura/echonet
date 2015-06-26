#!/bin/bash
#javac -classpath .:core.jar:ecj.jar $1
java -classpath .:core.jar:ecj.jar ${1%.*} $2 $3
