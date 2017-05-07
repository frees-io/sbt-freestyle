import sbtorgpolicies.model.{Dev, GitHubSettings}
import sbtorgpolicies.runnable.syntax._

pgpPassphrase := Some(getEnvVar("PGP_PASSPHRASE").getOrElse("").toCharArray)
pgpPublicRing := file(s"$gpgFolder/pubring.gpg")
pgpSecretRing := file(s"$gpgFolder/secring.gpg")

lazy val `sbt-freestyle` = project
  .in(file("."))
  .settings(name := "sbt-freestyle")
  .settings(Seq(
    addSbtPlugin("com.47deg" % "sbt-org-policies" % "0.4.22"),
    sbtPlugin := true,
    description := "sbt-plugin for Freestyle projects",
    startYear := Option(2017),
    homepage := Option(url("http://frees.io")),
    organizationHomepage := Option(new URL("http://frees.io/")),
    scalaVersion := "2.10.6",
    scalaOrganization := "org.scala-lang",
    crossScalaVersions := Seq("2.10.6"),
    resolvers += Resolver.sonatypeRepo("snapshots"),
    orgGithubSetting := GitHubSettings(
      organization = "frees-io",
      project = (name in LocalRootProject).value,
      organizationName = "Freestyle",
      groupId = "io.frees",
      organizationHomePage = url("http://frees.io"),
      organizationEmail = "hello@47deg.com"
    ),
    orgMaintainersSetting := List(
      Dev("47degfreestyle", Some("47 Degrees (twitter: @47deg)"), Some("hello@47deg.com"))),
    orgScriptTaskListSetting := List(
      orgValidateFiles.asRunnableItem,
      orgCheckSettings.asRunnableItem,
      "clean".asRunnableItemFull,
      "compile".asRunnableItemFull,
      "test".asRunnableItemFull
    )
  ): _*)
