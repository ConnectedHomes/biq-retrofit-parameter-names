#!/usr/bin/env bash

pushd retrofit-parameter-templates
sbt clean +publishLocal
popd
sbt clean +publish
pushd npm-package
sed -i 's/"version": ".*"/"version": "'"${BUILD_NUMBER}"'"/g' package.json
npm pack
popd
tar -C src/main/resources -czvf retrofit-parameter-names-${BUILD_NUMBER}.tar.gz parameters.csv