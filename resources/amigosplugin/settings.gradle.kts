rootProject.name = "amigosplugin"

include(":MagicPlugin:MagicAPI")
project(":MagicPlugin:MagicAPI").projectDir = file("MagicPlugin/MagicAPI")

include(":MagicPlugin:Magic")
project(":MagicPlugin:Magic").projectDir = file("MagicPlugin/Magic")

include(":MagicPlugin:CompatibilityLib:common")
project(":MagicPlugin:CompatibilityLib:common").projectDir = file("MagicPlugin/CompatibilityLib/common")

include(":MagicPlugin:CompatibilityLib:base")
project(":MagicPlugin:CompatibilityLib:base").projectDir = file("MagicPlugin/CompatibilityLib/base")

include(":MagicPlugin:CompatibilityLib:paper")
project(":MagicPlugin:CompatibilityLib:paper").projectDir = file("MagicPlugin/CompatibilityLib/paper")

include(":MagicPlugin:CompatibilityLib:base_v1_21_4")
project(":MagicPlugin:CompatibilityLib:base_v1_21_4").projectDir = file("MagicPlugin/CompatibilityLib/base_v1_21_4")

include(":MagicPlugin:CompatibilityLib:v1_21_11")
project(":MagicPlugin:CompatibilityLib:v1_21_11").projectDir = file("MagicPlugin/CompatibilityLib/v1_21_11")

include(":MagicPlugin:CompatibilityLib:main")
project(":MagicPlugin:CompatibilityLib:main").projectDir = file("MagicPlugin/CompatibilityLib/main")
