#!/bin/bash

INTROSPECTIONS="kb-api tcontroller"
CODEGEN_PATH="modules/common/src/main/scala/report/generated"
CODEGEN_PN="generated"

for target in ${INTROSPECTIONS[@]}
do
    escaped_target=${target//[-]/_}
    mkdir -p $CODEGEN_PATH/"$escaped_target"
    sbt "calibanGenClient ./$target/$target.graphql $CODEGEN_PATH/$escaped_target/graphql.scala --genView true --packageName $CODEGEN_PN.$escaped_target"
done
