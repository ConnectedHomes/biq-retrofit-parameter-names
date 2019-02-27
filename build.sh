#!/usr/bin/env bash

pushd retrofit-parameter-templates
sbt clean +compile +publishLocal
popd
sbt clean +compile +publishLocal