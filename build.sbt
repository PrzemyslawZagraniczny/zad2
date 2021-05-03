name := """scalaPlayZadanie"""
organization := "com.szkola"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.12"

libraryDependencies += guice
libraryDependencies += "com.typesafe.play" %% "play-slick" % "5.0.0"
libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "5.0.0"
//libraryDependencies += "slick.driver.SQLite" %% "play-slick-evolutions" % "3.0.3"
libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.34.0"

//resolvers += "scalaz-binary" at "https://dl.bintray.com/scalaz/releases"