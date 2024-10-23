#!/bin/bash

# download data sets from list of urls
while read -r url; do
  wget $url
  done < urls.txt

# compile and run java code
javac Main.java
java Main