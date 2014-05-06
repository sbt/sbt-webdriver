sbtPlugin := true

organization := "com.typesafe.sbt"

name := "sbt-webdriver"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.10.4"

resolvers ++= Seq(
    Resolver.url("sbt snapshot plugins", url("http://repo.scala-sbt.org/scalasbt/sbt-plugin-snapshots"))(Resolver.ivyStylePatterns),
    Resolver.sonatypeRepo("snapshots"),
    "Typesafe Releases Repository" at "http://repo.typesafe.com/typesafe/releases/",
    "Typesafe Snapshots Repository" at "http://repo.typesafe.com/typesafe/snapshots/"
    )

libraryDependencies ++= Seq(
  "com.typesafe" %% "webdriver" % "1.0.0-RC1"
)

addSbtPlugin("com.typesafe.sbt" % "sbt-web" % "1.0.0-RC1")

publishMavenStyle := false

publishTo := {
  if (isSnapshot.value) Some(Classpaths.sbtPluginSnapshots)
  else Some(Classpaths.sbtPluginReleases)
}
