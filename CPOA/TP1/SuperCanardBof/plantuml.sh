#!/bin/sh
UML='model.uml'
TYPE='PNG'
DOCLETPATH='/Users/bruel/dev/teaching/dut/cpoa/doclet'
echo "Creating $UML..."
javadoc \
-private \
-quiet \
-J-DdestinationFile=$UML \
-J-DcreatePackages=false \
-J-DshowPublicMethods=true \
-J-DshowPublicConstructors=false \
-J-DshowPublicFields=true \
-doclet de.mallox.doclet.PlantUMLDoclet -docletpath $DOCLETPATH/plantUmlDoclet.jar \
-sourcepath src src/**
echo "Done."

TYPE='png'
echo "Converting $UML to $TYPE..."
java -jar bin/plantuml.jar \
  -config "./config.cfg" \
  -t $TYPE $UML
echo "Done."
