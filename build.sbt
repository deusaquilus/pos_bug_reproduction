

lazy val root = project
  .in(file("."))
  .settings(
    name := "dotty-simple",
    version := "0.1.0",
    resolvers += Resolver.mavenLocal,

    scalaVersion := "3.0.0-M2", // "0.21.0-RC1", //"0.22.0-bin-20200114-193f7de-NIGHTLY", //dottyLatestNightlyBuild.get,

    scalacOptions ++= Seq(
      "-language:implicitConversions"
    ),

    libraryDependencies ++= Seq()
  )
