import Dependencies._

ThisBuild / scalaVersion := "$scala_version$"
ThisBuild / version := "$version$"
ThisBuild / organization := "$organization$"
ThisBuild / organizationName := "$organizationName$"

lazy val root = Project(id = "$name;format="normalize"$", base = file("."))
  .settings(
    name := "$name$",
    publishArtifact := false
  )
  .aggregate($module1$, $module2$)

lazy val $module1$ = Project(id = "$module_prefix$-$module1$", base = file("$module_prefix$-$module1$"))  
  .settings(name := "$module1$")
  .settings(
    scalacOptions ++= List("-Ymacro-annotations", "-Yrangepos", "-Wconf:cat=unused:info"),
    libraryDependencies ++= Seq(
      CompilerPlugin.kindProjector,
      CompilerPlugin.betterMonadicFor,
      CompilerPlugin.semanticDB,
      Libraries.scalatest,
      Libraries.scalatic
    )
  )

lazy val $module2$ = Project(id = "$module_prefix$-$module2$", base = file("$module_prefix$-$module2$"))  
  .settings(name := "$module2$")
  .settings(
    scalacOptions ++= List("-Ymacro-annotations", "-Yrangepos", "-Wconf:cat=unused:info"),
    libraryDependencies ++= Seq(
      CompilerPlugin.kindProjector,
      CompilerPlugin.betterMonadicFor,
      CompilerPlugin.semanticDB,
      Libraries.apacheCommonsCodec,
      Libraries.apacheCommonsLang,
      Libraries.apacheCommonsText,
      Libraries.apacheCommonsIo,
      Libraries.cats,
      Libraries.catsEffect,
      Libraries.catsRetry,
      Libraries.squants,
      Libraries.fs2,
      Libraries.hikari,
      Libraries.circeCore,
      Libraries.circeGeneric,
      Libraries.circeParser,
      Libraries.circeRefined,
      Libraries.cirisCore,
      Libraries.cirisEnum,
      Libraries.cirisRefined,
      Libraries.derevoCore,
      Libraries.derevoCats,
      //Libraries.derevoCirce,
      Libraries.doobieCore,
      Libraries.doobieH2,
      Libraries.doobieHikari,
      Libraries.http4sServer,
      Libraries.http4sClient,
      Libraries.http4sDsl,
      Libraries.http4sJwtAuth,
      Libraries.http4sCirce,
      Libraries.http4sScalaTags,
      Libraries.javaxCrypto,
      Libraries.log4cats,
      Libraries.logback % Runtime,
      Libraries.monocleCore,
      Libraries.monocleLaw,
      Libraries.newtype,
      Libraries.refinedCore,
      Libraries.refinedCats,
      Libraries.scalaTags,
      Libraries.scalatest,
      Libraries.scalatic,
    )
  )
  .dependsOn($module1$)
