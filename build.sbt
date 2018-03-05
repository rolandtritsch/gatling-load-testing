enablePlugins(GatlingPlugin)
enablePlugins(AssemblyPlugin)

scalaVersion := "2.12.4"

// dependencies for Gatling
libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.3.0" % "it,runtime"
libraryDependencies += "io.gatling" % "gatling-test-framework" % "2.3.0" % "it,runtime"

// make '~' work (again :))
watchSources += baseDirectory.value / "src" / "it"

// configure the assembly
fullClasspath in assembly := (fullClasspath in GatlingIt).value
mainClass in assembly := Some("io.gatling.app.Gatling")
assemblyMergeStrategy in assembly := {
  case path if path.endsWith("io.netty.versions.properties") => MergeStrategy.first
  case path => {
    val currentStrategy = (assemblyMergeStrategy in assembly).value
    currentStrategy(path)
  }
}
test in assembly := {}