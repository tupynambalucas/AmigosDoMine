# Purpur API Overview (1.21.8)

**Purpur** is a fork of **Paper** (which is a fork of Spigot). It focuses on **Performance**, **Configurability**, and **New Features**.

This document outlines the key differences and API features available in Purpur 1.21.8+.

## 1. The Hierarchy 🧬

Understanding where Purpur sits is crucial:
`Vanilla Minecraft` -> `Bukkit` -> `Spigot` -> `Paper` -> `Pufferfish` -> **`Purpur`**

*   **You have access to ALL APIs** from the parents.
*   Most "Purpur" features are actually configuration toggles (`purpur.yml`) rather than new Java APIs.
*   However, Purpur does expose some specific methods in `org.purpurmc.purpur.*`.

## 2. Key API Features 🛠️

### 2.1. Component Logger (Paper Standard)
Purpur fully embraces the `ComponentLogger` from Paper.
```kotlin
// Instead of getLogger().info("Hello")
componentLogger.info(Component.text("Hello").color(NamedTextColor.GREEN))
```

### 2.2. RIDICULOUS Configurability ⚙️
Purpur's main selling point is the `purpur.yml`. You can change almost anything:
*   **Mobs:** Riders, attributes, behavior (e.g., `zombie.aggressive-towards-villager: false`).
*   **Gameplay:** Silk touch spawners, infinity bow needs no arrows, etc.
*   **Performance:** Alternate keep-alive handling, entity activation ranges.

### 2.3. Entities & mixins
Purpur adds extra methods to Entities via its API:
*   `entity.setRidable(boolean)` (Make anything rideable!)
*   `entity.setControllable(boolean)` (Control it with WASD!)

### 2.4. Custom Packets & Events
*   **PlayerAFKEvent**: Native event for AFK status.
*   **TPSBar**: Native bossbar for TPS/Lag monitoring.

## 3. Configuration Files 📂

In `packages/minecraft/`, you will find:
*   `purpur.yml`: The main config.
*   `paper-global.yml` / `paper-world-defaults.yml`: Parent configs.

## 4. Useful Links 🔗

*   **Javadoc**: [https://purpurmc.org/javadoc](https://purpurmc.org/javadoc)
*   **Docs**: [https://purpurmc.org/docs](https://purpurmc.org/docs)
*   **GitHub**: [https://github.com/PurpurMC/Purpur](https://github.com/PurpurMC/Purpur)
