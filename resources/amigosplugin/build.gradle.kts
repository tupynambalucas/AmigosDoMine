import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "2.3.0"
    id("io.github.goooler.shadow") version "8.1.8"
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

tasks.build {
    dependsOn("shadowJar")
}

val deployPlugins by tasks.registering(Copy::class) {
    description = "Builds all plugins and copies them to the server plugins directory"
    group = "deployment"

    dependsOn(":shadowJar")
    dependsOn(":MagicPlugin:Magic:jar")

    from(tasks.named<ShadowJar>("shadowJar").get().archiveFile)
    from(project(":MagicPlugin:Magic").tasks.named("jar").get().outputs.files)
    
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
