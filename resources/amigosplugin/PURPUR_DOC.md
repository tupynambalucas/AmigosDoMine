# 🟣 Purpur: Architecture & Development for Kotlin

This guide covers the architecture, internal logic, and development setup for Purpur plugins using Kotlin.

## 1. The Ecosystem Hierarchy 🧬

To understand Purpur, you must understand the inheritance chain. Purpur is a highly configurable, performance-oriented fork of PaperMC.

`Vanilla` ➡️ `Bukkit/Spigot` (API) ➡️ `Paper` (Optimization/Modern API) ➡️ `Pufferfish` (Hardcore Performance) ➡️ **`Purpur`** (Features & Customization)

*   **Inheritance:** Purpur contains *every* patch from Paper and Pufferfish.
*   **What is Purpur?** It's a drop-in replacement for Paper servers, offering enhanced configurability and new gameplay features (like rideable mobs) that standard upstream repos might reject.

## 2. API and Dependency Information

To develop Kotlin plugins for Purpur, include the API in your project. It bundles functionalities from Pufferfish, Paper, Spigot, and Bukkit.

*   **Javadoc:** [https://purpurmc.org/javadoc](https://purpurmc.org/javadoc)

### Gradle (Kotlin DSL) Setup

**1. Add the Purpur Maven Repository:**
```kotlin
repositories {
    maven("https://repo.purpurmc.org/snapshots")
}
```

**2. Add the Dependency:**
```kotlin
dependencies {
    compileOnly("org.purpurmc.purpur", "purpur-api", "1.21.11-R0.1-SNAPSHOT")
}
```

## 3. Architecture & Build Logic 🛠️

Purpur uses a patch-based system and does not store the full Minecraft source code.

*   **Patch Workflow:**
    1.  `./gradlew applyPatches`: Decompiles Minecraft and applies Paper/Pufferfish/Purpur patches.
    2.  **API Patches:** Modifies `purpur-api` (Bukkit).
    3.  **Server Patches:** Modifies `purpur-server` (NMS/CraftBukkit).
*   **Compiling:** Use `./gradlew build`. JARs are in `Purpur-API/build/libs` and `Purpur-Server/build/libs`.
*   **Local Install:** Run `./gradlew publishToMavenLocal`.

## 4. Configuration Architecture ⚙️

Purpur's granular configuration is handled per world and is one of its most powerful features.

*   **Logic:** `org.purpurmc.purpur.PurpurWorldConfig` maps `purpur.yml` options (e.g., `zombie.aggressive-towards-villager`) directly to public static fields in the code.
*   **AI Implications:** Always check `PurpurWorldConfig` before assuming a behavior bug is in a plugin; the server core often modifies attributes, AI goals, and despawn ranges natively.

## 5. Purpur-Specific API & Modern Paper Features

### 5.1. Modern Command Registration (1.21+)
Since we use `paper-plugin.yml`, use the `LifecycleEventManager` and `BasicCommand` (Brigadier).

```kotlin
class MyCommand : BasicCommand {
    override fun execute(stack: CommandSourceStack, args: Array<out String>) {
        stack.sender.sendMessage(Component.text("Hello!"))
    }
}

// In onEnable
val manager = this.lifecycleManager
manager.registerEventHandler(LifecycleEvents.COMMANDS) { event ->
    event.registrar().register("mycommand", MyCommand())
}
```

### 5.2. Internal Plugin & Purpur Events
Purpur adds specific events in `org.purpurmc.purpur.event`. It also uses an internal plugin context (**`MinecraftInternalPlugin`**) to register core commands (like `/purpur`, `/rambar`) and listen to events using standard Bukkit structures from within the server core.