#!/usr/bin/env bash

pushd retrofit-parameter-templates
sbt clean +publishLocal
popd
sbt clean +publishLocal
pushd npm-package
npm pack
popd