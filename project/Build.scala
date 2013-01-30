import sbt._
import Keys._

import java.io.{File, FileReader}
import java.util.Properties

import fm.last.ivy.plugins.svnresolver.SvnResolver

object StandardProjectPlugin extends Build {
  lazy val root = Project(
    id = "sbt-package-dist",
    base = file("."),
    settings = Project.defaultSettings ++
      CrossBuilding.scriptedSettings
  ).settings(
    organization := "com.twitter",
    name := "sbt-package-dist",
    version := "1.0.7-SNAPSHOT",
    sbtPlugin := true,
    libraryDependencies ++= Seq (
      "ivysvn" % "ivysvn" % "2.1.0",
      "org.markdownj" % "markdownj" % "0.3.0-1.0.2b4",
      "org.freemarker" % "freemarker" % "2.3.16"
    ),
    scalaVersion := "2.9.1",
    crossScalaVersions := Seq("2.9.1", "2.9.2", "2.10.0"),
    CrossBuilding.crossSbtVersions := Seq("0.11.2", "0.11.3", "0.12.0", "0.12.1")
  )
}
