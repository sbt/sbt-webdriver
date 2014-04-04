sbtPlugin := true

organization := "com.typesafe.sbt"

name := "sbt-webdriver"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.10.3"

resolvers ++= Seq(
    Resolver.url("sbt snapshot plugins", url("http://repo.scala-sbt.org/scalasbt/sbt-plugin-snapshots"))(Resolver.ivyStylePatterns),
    Resolver.sonatypeRepo("snapshots"),
    "Typesafe Releases Repository" at "http://repo.typesafe.com/typesafe/releases/",
    "Typesafe Snapshots Repository" at "http://repo.typesafe.com/typesafe/snapshots/"
    )

libraryDependencies ++= Seq(
  "com.typesafe" %% "webdriver" % "1.0.0-M2"
)

addSbtPlugin("com.typesafe.sbt" % "sbt-web" % "1.0.0-M2")

// FIXME: Working around https://github.com/sbt/sbt/issues/1156#issuecomment-39317363
isSnapshot := true

publishMavenStyle := false

publishTo := {
    val isSnapshot = version.value.contains("-SNAPSHOT")
    val scalasbt = "http://repo.scala-sbt.org/scalasbt/"
    val (name, url) = if (isSnapshot)
                        ("sbt-plugin-snapshots", scalasbt + "sbt-plugin-snapshots")
                      else
                        ("sbt-plugin-releases", scalasbt + "sbt-plugin-releases")
    Some(Resolver.url(name, new URL(url))(Resolver.ivyStylePatterns))
}