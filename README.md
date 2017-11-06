
[comment]: # (Start Badges)

[![Build Status](https://travis-ci.org/frees-io/sbt-freestyle.svg?branch=master)](https://travis-ci.org/frees-io/sbt-freestyle) [![License](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://raw.githubusercontent.com/frees-io/sbt-freestyle/master/LICENSE) [![Join the chat at https://gitter.im/47deg/freestyle](https://badges.gitter.im/47deg/freestyle.svg)](https://gitter.im/47deg/freestyle?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge) [![GitHub Issues](https://img.shields.io/github/issues/frees-io/sbt-freestyle.svg)](https://github.com/frees-io/sbt-freestyle/issues)

[comment]: # (End Badges)

# sbt-freestyle

sbt-plugin for Freestyle projects within of `frees-io` organization.

In other words, it's just a bridge between [sbt-org-policies](https://github.com/47deg/sbt-org-policies) and all the projects within of `frees-io` organization. Its main responsibility is to set up common configurations across all the freestyle projects, as well as providing some sbt settings, tasks, commands, and utilities offered by the `sbt-org-policies` plugin. Hence, it might not have sense using it outside the `frees-io` organization.

## Installation

To get started with SBT, simply add the following to your `plugins.sbt` file.

[comment]: # (Start Replace)

```scala
addSbtPlugin("io.frees" % "sbt-freestyle" % "0.3.9")
```

[comment]: # (End Replace)

[comment]: # (Start Copyright)
# Copyright

Freestyle is designed and developed by 47 Degrees

Copyright (C) 2017 47 Degrees. <http://47deg.com>

[comment]: # (End Copyright)