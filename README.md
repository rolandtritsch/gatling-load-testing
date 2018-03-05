# Self-contained assembly/jar for a Gatling load test

To make this work you need to ...

* clone the repo
* run the test with `sbt gatling-it:testOnly computerdatabase:BasicItSimulation`
* build the assembly with `sbt clean gatling-it:compile assembly`
* run the test from/with the jar `java -jar target/scala-2.12/... -s computerdatabase.BasicItSimulation`
