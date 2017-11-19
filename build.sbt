name := "FurnitureOnline"

version := "1.0"

lazy val `FurnitureOnline` = (project in file(".")).enablePlugins(PlayJava)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

scalaVersion := "2.11.11"

libraryDependencies ++= Seq( javaJdbc , cache , javaWs )

libraryDependencies += jdbc
libraryDependencies += javaJdbc
libraryDependencies += "org.hibernate" % "hibernate-core" % "5.2.10.Final"
//libraryDependencies += "org.apache.commons" % "commons-collections4" % "4.1"
libraryDependencies += cache
libraryDependencies += javaWs
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.41"
unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

libraryDependencies += "commons-logging" % "commons-logging" % "1.0.4"
libraryDependencies += "dom4j" % "dom4j" % "1.6.1"



import com.typesafe.sbt.packager.docker._
//name := """play-hibernate"""
//name := """Srujanika Matrimony"""

//version := "1.0-SNAPSHOT"
version := "26-Oct-2017"

lazy val root = (project in file(".")).enablePlugins(PlayJava, JavaAppPackaging, DockerPlugin)

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")
//scalaVersion := "2.12"

//val hazelcastVersion = "3.8.2"
//val hazelcastVersion = "3.4.2"
//val hazelcastDependency = "com.hazelcast" % "hazelcast" % "3.8.5"
//val hazelcastClientDependency = "com.hazelcast" % "hazelcast-client" % "3.8.5"

resolvers += Resolver.mavenLocal
resolvers += "bintray" at "http://dl.bintray.com/fmasion/maven"
//resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
//resolvers += Resolver.typesafeRepo("releases")
//resolvers += "sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
//hazelcastco


libraryDependencies ++= Seq(
  // If you enable PlayEbean plugin you must remove these
  // JPA dependencies to avoid conflicts

  javaJdbc,
  javaJpa,
  //"org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final",


  //
  //"org.log4j" % "1.2.9",
  //"mysql" % "mysql-connector-java" % "5.1.36",
  cache,
  javaWs,
  "org.assertj" % "assertj-core" % "3.1.0" % "test",
  "org.apache.commons" % "commons-lang3" % "3.4",
  //"com.hazelcast" % "hazelcast" % hazelcastVersion,
  //"com.hazelcast" % "hazelcast-client" % hazelcastVersion,
  //  hazelcastDependency,
  //  hazelcastClientDependency,
  "com.typesafe.play" % "filters-helpers_2.11" % "2.5.11",
  //"org.mongodb" % "mongo-java-driver" % "3.4.2",
  "org.springframework.data" % "spring-data-mongodb" % "1.10.1.RELEASE",
  //  "org.bouncycastle" % "bcprov-jdk15on" % "1.54",

  "org.hibernate" % "hibernate-c3p0" % "3.6.10.Final",
  //"com.google.inject" % "guice" % "4.0-beta",
  "com.typesafe.play" % "play-mailer_2.11" % "5.0.0-M1",
  "org.apache.commons" % "commons-email" % "1.4",

  "com.fasterxml.jackson.core" % "jackson-core" % "2.8.7",
  "com.google.code.gson" % "gson" % "2.3.1",
  "com.bazaarvoice.jolt" % "json-utils" % "0.0.10",
  "commons-validator" % "commons-validator" % "1.4.0",
  // "org.apache.kafka" % "kafka-clients" % "0.10.1.0",
  // "org.apache.kafka" % "kafka_2.10" % "0.8.1",
  //  "com.opencsv" % "opencsv" % "3.9",
  "org.apache.commons" % "commons-math3" % "3.6.1",
  "org.ehcache" % "ehcache" % "3.4.0",
  "org.ehcache" % "ehcache-clustered" % "3.4.0",
  "org.springframework" % "spring-oxm" % "4.3.9.RELEASE"
)
//libraryDependencies += "tv.cntt" % "xitrum-hazelcast3" % "1.14.0"
//libraryDependencies += "com.hazelcast" %  "hazelcast"         % "3.7.5"
//libraryDependencies += "com.hazelcast" %  "hazelcast-client"  % "3.7.5"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
//croutesGenerator := InjectedRoutesGenerator

// --------------------
// ------ DOCKER ------
// --------------------
// build with activator docker:publishLocal

// change to smaller base image
dockerBaseImage := "frolvlad/alpine-oraclejdk8:latest"
dockerCommands := dockerCommands.value.flatMap {
  case cmd@Cmd("FROM", _) => List(cmd, Cmd("RUN", "apk update && apk add bash"))
  case other => List(other)
}

// setting a maintainer which is used for all packaging types</pre>
maintainer := "Me"

// exposing the play ports
//listen to defarent port
PlayKeys.devSettings := Seq("play.server.http.port" -> "9000")
//dockerExposedPorts in Docker := Seq(9000, 9443)

//PlayKeys.playWatchService := play.sbtplugin.run.PlayWatchService.sbt(pollInterval.value)

// publish to repo
//dockerRepository := Some("quay.io/")
//dockerUpdateLatest := true

// run this with: docker run -p 9000:9000 <name>:<version>

//routesGenerator := InjectedRoutesGenerator
//routesGenerator := StaticRoutesGenerator

