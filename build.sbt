import sbtorgpolicies.OrgPoliciesPlugin.autoImport.orgEnforcedFilesSetting
import sbtorgpolicies.model._
import sbtorgpolicies.runnable.syntax._
import sbtorgpolicies.templates._
import sbtorgpolicies.templates.badges._

pgpPassphrase := Some(getEnvVar("PGP_PASSPHRASE").getOrElse("").toCharArray)
pgpPublicRing := file(s"$gpgFolder/pubring.gpg")
pgpSecretRing := file(s"$gpgFolder/secring.gpg")

lazy val `sbt-freestyle` = project
  .in(file("."))
  .settings(name := "sbt-freestyle")
  .settings(Seq(
    addSbtPlugin(%("sbt-org-policies", true)),
    sbtPlugin := true,
    crossSbtVersions := Seq(sbtV.`0.13`, sbtV.`1.0`),
    description := "sbt-plugin for Freestyle projects",
    startYear := Option(2017),
    homepage := Option(url("http://frees.io")),
    organizationHomepage := Option(new URL("http://frees.io/")),
    scalaVersion := scalac.`2.12`,
    scalaOrganization := "org.scala-lang",
    crossScalaVersions := Seq(scalac.`2.12`),
    resolvers += Resolver.sonatypeRepo("snapshots"),
    orgProjectName := "Freestyle",
    orgGithubSetting := GitHubSettings(
      organization = "frees-io",
      project = (name in LocalRootProject).value,
      organizationName = "47 Degrees",
      groupId = "io.frees",
      organizationHomePage = url("http://47deg.com"),
      organizationEmail = "hello@47deg.com"
    ),
    // format: OFF
    orgBadgeListSetting := List(
      TravisBadge.apply,
      LicenseBadge.apply,
      // Gitter badge (owner field) can be configured with default value if we migrate it to the frees-io organization
      { info => GitterBadge.apply(info.copy(owner = "47deg", repo = "freestyle")) },
      GitHubIssuesBadge.apply
    ),
    orgEnforcedFilesSetting := List(
      LicenseFileType(orgGithubSetting.value, orgLicenseSetting.value, startYear.value),
      ContributingFileType(
        orgProjectName.value,
        // Organization field can be configured with default value if we migrate it to the frees-io organization
        orgGithubSetting.value.copy(project = "freestyle")),
      AuthorsFileType(
        name.value,
        orgGithubSetting.value,
        orgMaintainersSetting.value,
        orgContributorsSetting.value),
      NoticeFileType(
        orgProjectName.value,
        orgGithubSetting.value,
        orgLicenseSetting.value,
        startYear.value),
      VersionSbtFileType,
      ChangelogFileType,
      ReadmeFileType(
        orgProjectName.value,
        orgGithubSetting.value,
        startYear.value,
        orgLicenseSetting.value,
        orgCommitBranchSetting.value,
        sbtPlugin.value,
        name.value,
        version.value,
        scalaBinaryVersion.value,
        sbtBinaryVersion.value,
        orgSupportedScalaJSVersion.value,
        orgBadgeListSetting.value
      )
    ),
    orgMaintainersSetting := List(
      Dev("47degfreestyle", Some("47 Degrees (twitter: @47deg)"), Some("hello@47deg.com"))),
    orgScriptTaskListSetting := List(
      orgCheckSettings.asRunnableItem,
      "clean".asRunnableItemFull,
      "compile".asRunnableItemFull,
      "test".asRunnableItemFull
    )
  ): _*)
