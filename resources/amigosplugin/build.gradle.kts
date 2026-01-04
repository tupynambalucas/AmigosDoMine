import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "2.3.0"
    id("io.github.goooler.shadow") version "8.1.8"
    checkstyle
}

group = "com.tupynambalucas.mine.purpur"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.purpurmc.org/snapshots")
    maven("https://maven.elmakers.com/repository/")
}

sourceSets {
    main {
    }
}

dependencies {
    compileOnly("org.purpurmc.purpur", "purpur-api", "1.21.11-R0.1-SNAPSHOT")
    compileOnly(project(":MagicPlugin:MagicAPI"))
    compileOnly("com.google.code.findbugs:jsr305:3.0.2")
    compileOnly("org.apache.commons:commons-lang3:3.20.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}


val targetJavaVersion = 21
kotlin {
    jvmToolchain(targetJavaVersion)
}

subprojects {
    apply(plugin = "java-library")
    apply(plugin = "checkstyle")

    configure<CheckstyleExtension> {
        toolVersion = "8.29"
        configFile = rootProject.file("MagicPlugin/checkstyle.xml")
        isIgnoreFailures = true
        maxWarnings = 0
    }

    configurations.all {
        resolutionStrategy {
            force("org.spigotmc:spigot-api:1.21.11-R0.1-SNAPSHOT")
            force("org.geysermc.cumulus:cumulus:1.1.2")
        }
    }

    repositories {
        mavenCentral()
        maven("https://repo.citizensnpcs.co/")
        maven("http://repo.citizensnpcs.co/") {
            isAllowInsecureProtocol = true
        }
        maven("https://maven.elmakers.com/repository/")
        maven("https://repo.purpurmc.org/snapshots")
        maven("https://repo.mvdw-software.com/content/groups/public/")
        maven("https://jitpack.io")
        maven("https://repo.mikeprimm.com/")
        maven("https://repo.onarandombox.com/content/groups/public/")
        maven("https://repo.md-5.net/content/groups/public")
        maven("https://mvn.lumine.io/repository/maven-public/")
        maven("https://mvn.lib.co.nz/public/")
        maven("https://repo.codemc.io/repository/maven-public/")
        maven("https://repo.glaremasters.me/repository/towny/")
        maven("https://raw.githubusercontent.com/FabioZumbi12/RedProtect/mvn-repo/")
        maven("https://repo.opencollab.dev/main/")
        maven("https://repo.opencollab.dev/maven-snapshots/")
        maven("https://repo.opencollab.dev/maven-releases/")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        maven("https://repo.azisaba.net/repository/maven-public/")
        maven("https://repo.opencollab.dev/maven-snapshots/")
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(21))
        }
    }

    dependencies {
        "compileOnly"("com.google.code.findbugs:jsr305:3.0.2")
    }
}

project(":MagicPlugin:CompatibilityLib:common") {
    dependencies {
        "api"("org.apache.commons:commons-lang3:3.17.0")
        "api"("org.apache.commons:commons-text:1.13.0")
        "compileOnly"("org.spigotmc:spigot-api:1.21.11-R0.1-SNAPSHOT")
        "api"(project(":MagicPlugin:MagicAPI"))
    }
}

project(":MagicPlugin:CompatibilityLib:base") {
    dependencies {
        "api"(project(":MagicPlugin:CompatibilityLib:common"))
        "api"(project(":MagicPlugin:CompatibilityLib:paper")) {
            exclude(group = "io.papermc.paper", module = "paper-api")
        }
        "compileOnly"("io.papermc.paper:paper-api:1.21.1-R0.1-SNAPSHOT")
    }
}

configure(subprojects.filter { it.path.contains(":CompatibilityLib:") && it.name != "paper" && it.name != "base" }) {
    dependencies {
        "compileOnly"(project(":MagicPlugin:MagicAPI"))
        "compileOnly"("org.spigotmc:spigot-api:1.21.11-R0.1-SNAPSHOT")
    }
}

project(":MagicPlugin:CompatibilityLib:paper") {
    dependencies {
        "compileOnly"(project(":MagicPlugin:MagicAPI"))
        "api"(project(":MagicPlugin:CompatibilityLib:common"))
        "compileOnly"("io.papermc.paper:paper-api:1.21.11-R0.1-SNAPSHOT")
    }
}

project(":MagicPlugin:CompatibilityLib:base_v1_21_4") {
    dependencies {
         "api"(project(":MagicPlugin:CompatibilityLib:base"))
         "compileOnly"("org.spigotmc:spigot-api:1.21.11-R0.1-SNAPSHOT")
    }
}

project(":MagicPlugin:CompatibilityLib:v1_21_11") {
    dependencies {
        "api"(project(":MagicPlugin:CompatibilityLib:base_v1_21_4"))
        "api"(project(":MagicPlugin:CompatibilityLib:paper"))
        "compileOnly"("org.spigotmc:spigot-api:1.21.11-R0.1-SNAPSHOT")
        "compileOnly"("org.spigotmc:spigot:1.21.11-R0.1-SNAPSHOT:remapped-mojang")
    }
}

project(":MagicPlugin:CompatibilityLib:main") {
    dependencies {
        "api"(project(":MagicPlugin:CompatibilityLib:common"))
        "api"(project(":MagicPlugin:CompatibilityLib:base"))
        "api"(project(":MagicPlugin:CompatibilityLib:paper"))
        "api"(project(":MagicPlugin:CompatibilityLib:base_v1_21_4"))
        "api"(project(":MagicPlugin:CompatibilityLib:v1_21_11"))
    }
}



tasks.build {
    dependsOn("shadowJar")
    dependsOn(":MagicPlugin:Magic:shadowJar")
}

val deployPlugins by tasks.registering(Copy::class) {
    description = "Builds all plugins and copies them to the server plugins directory"
    group = "deployment"

    dependsOn(":shadowJar")
    dependsOn(":MagicPlugin:Magic:shadowJar")

    from(tasks.named<ShadowJar>("shadowJar").get().archiveFile)
    from(project(":MagicPlugin:Magic").tasks.named<ShadowJar>("shadowJar").get().archiveFile)
    
    into(file("../build/plugins"))
}

tasks.withType<ShadowJar> {
    destinationDirectory.set(file("../build/plugins"))
    archiveFileName.set("AmigosPlugin.jar")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    mergeServiceFiles()
    exclude("META-INF/*.SF", "META-INF/*.DSA", "META-INF/*.RSA")
}

tasks.processResources {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    val props = mapOf("version" to version)
    inputs.properties(props)
    filteringCharset = "UTF-8"
    filesMatching("paper-plugin.yml") {
        expand(props)
    }
}
