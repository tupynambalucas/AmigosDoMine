# Purpur for Kotlin Plugin Developers

This guide summarizes key aspects of Purpur relevant for developers building Minecraft plugins with Kotlin, based on the official Purpur documentation.

## 1. What is Purpur?

Purpur is a highly configurable, performance-oriented fork of PaperMC, which itself is an optimized fork of Spigot. It aims to provide a drop-in replacement for Paper servers, offering enhanced configurability and new gameplay features.

**Key Characteristics:**
*   **Drop-in Replacement:** Can be used in place of Paper servers.
*   **Configurability:** Designed with extensive configuration options to fine-tune server behavior.
*   **Feature-Rich:** Introduces new and exciting gameplay features beyond standard Paper/Spigot.

## 2. API and Dependency Information

For Kotlin plugin development, you'll need to include the Purpur API as a dependency in your project. The Purpur API bundles all functionalities from Pufferfish, Paper, Spigot, and Bukkit, ensuring comprehensive access to Minecraft's server-side APIs.

### Javadoc
The official Javadoc for Purpur can be found at: [https://purpurmc.org/javadoc](https://purpurmc.org/javadoc)

### Gradle (Kotlin DSL) Dependency Setup

To include the Purpur API in your `build.gradle.kts` file, add the following:

**1. Add the Purpur Maven Repository:**
```kotlin
repositories {
    // ... other repos ...
    maven("https://repo.purpurmc.org/snapshots") // Add this somewhere after mavenCentral()
    // ... other repos ...
}
```

**2. Add the Purpur API Dependency:**
```kotlin
dependencies {
    // ... other dependencies ...
    compileOnly("org.purpurmc.purpur", "purpur-api", "1.21.8-R0.1-SNAPSHOT") // Replace with the latest version
    // ... other dependencies ...
}
```

## 3. Configuration Options (`purpur.yml`)

The Purpur documentation highlights that it is "designed for configurability". While specific `purpur.yml` options are not detailed on the main overview page, they are available on a dedicated "Configuration" page linked from the documentation. Developers should consult this page for a comprehensive list of server-side configuration options that can influence gameplay and server performance.

## 4. Building and Setting Up

For those interested in contributing to Purpur or building it from source:

*   **Initial Setup:** Run `./gradlew applyPatches` in the project root.
*   **Creating a Patch:** Add a commit to `Purpur-API` or `Purpur-Server`, then run `./gradlew rebuildPatches`.
*   **Compiling:** Use `./gradlew build` to compile the API and server JARs. Compiled JARs will be located in `Purpur-API/build/libs` and `Purpur-Server/build/libs`.
*   **Local Maven Install:** To install `purpur-api` and `purpur` to your local Maven repository, run `./gradlew publishToMavenLocal`.

## 5. Purpur-Specific API & Modern Paper Features

Purpur inherits all of Paper's modern API features.

### 5.1. Modern Command Registration (1.21+)
Since we use `paper-plugin.yml` (the new plugin loader), we **CANNOT** use the legacy `plugin.yml` `commands` section.
Instead, we use the **LifecycleEventManager** and **BasicCommand** (Brigadier).

**Example:**
```kotlin
// 1. Create a command class
class MyCommand : BasicCommand {
    override fun execute(stack: CommandSourceStack, args: Array<out String>) {
        stack.sender.sendMessage(Component.text("Hello!"))
    }
}

// 2. Register in onEnable
override fun onEnable() {
    val manager = this.lifecycleManager
    manager.registerEventHandler(LifecycleEvents.COMMANDS) { event ->
        event.registrar().register("mycommand", MyCommand())
    }
}
```

### 5.2. Purpur Events
Purpur adds specific events on top of Paper. Check `org.purpurmc.purpur.event` in the Javadocs.
