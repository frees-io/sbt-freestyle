/*
 * Copyright 2017-2018 47 Degrees, LLC. <http://www.47deg.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package freestyle

import sbt._
import sbt.Keys._

import sbt.io.CopyOptions

object compat {

  lazy val packageDocSettings: Seq[Def.Setting[_]] = Seq(
    packageDoc in Compile := {
      val sourceFile = (baseDirectory in LocalRootProject).value / "README.md"
      val targetFile = crossTarget.value / s"${name.value}-javadoc.jar"

      IO.copy(Seq(sourceFile -> targetFile), CopyOptions().withOverwrite(true)).toSeq

      targetFile
    }
  )

}