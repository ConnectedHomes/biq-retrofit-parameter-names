#!/usr/bin/env bash

pushd retrofit-parameter-templates
sbt clean +publishLocal
popd
sbt clean +publish
pushd npm-package
sed -i 's/"version": ".*"/"version": "'"${BUILD_NUMBER}"'"/g' package.json
npm pack
popd
gzip -c src/main/resources/parameters.csv > retrofit-parameter-names-${BUILD_NUMBER}.csv.gz