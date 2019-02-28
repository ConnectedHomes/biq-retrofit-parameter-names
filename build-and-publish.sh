#!/usr/bin/env bash

pushd retrofit-parameter-templates
sbt clean +publishLocal
popd
sbt clean +publish
pushd npm-package
npm pack
popd
tar -czvf retrofit-parameter-names-${BUILD_NUMBER}.tar.gz /src/main/resources/parameters.csv