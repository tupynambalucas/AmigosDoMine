# ⚡ Purpur API Reference (1.21.11)

Purpur is a fork of Paper that focuses on performance, configurability, and unique features. This document details the specific Java API additions available in `purpur-api` that are **not** present in Paper or Spigot.

## 1. The Hierarchy 🧬

`Vanilla Minecraft` -> `Bukkit` -> `Spigot` -> `Paper` -> `Pufferfish` -> **`Purpur`**
You have access to ALL APIs from the parent projects. Most "Purpur" features are configuration toggles, but many expose unique methods in `org.purpurmc.purpur.*`.

## 2. Exclusive Event API (`org.purpurmc.purpur.event`) 🎯

Purpur exposes hooks into internal Minecraft logic usually hardcoded or difficult to access.

### Entity & AI Events
*   **`RidableMoveEvent`**: Fires when a mob (configured as ridable in `purpur.yml`) is moved by a rider.
*   **`RidableSpacebarEvent`**: Triggers when a player presses SPACE while riding a mob. Use this for custom mount abilities (jump, shoot fireball).
*   **`PreEntityExplodeEvent`**: Fires **before** the explosion creates damage/block lists. Cancelling this is significantly more performant than `EntityExplodeEvent`.
*   **`BeeEvents`**: Granular control over pollination lifecycle (`BeeFoundFlowerEvent`, `BeeStartedPollinatingEvent`).
*   **`GoatRamEntityEvent`**: Specific hook for the Goat's ramming AI goal.

### Player & Inventory Events
*   **`PlayerAFKEvent`**: Native AFK tracking. No need for complex schedulers. Use `.isAfk()` and `.setBroadcastMsg(boolean)`.
*   **`AnvilTakeResultEvent` / `AnvilUpdateResultEvent`**: Modify anvil repair costs and result generation logic without NMS.
*   **`PlayerBookTooLargeEvent`**: Security hook to prevent BookBan exploits when a book edit packet exceeds safe limits.

## 3. Tool & Block Behavior Interfaces (`org.purpurmc.purpur.tool`) 🧰

Standardized interfaces to check interactions without hardcoding Material lists:
*   **`Strippable`**: Defines items (axes) that can strip blocks (logs).
*   **`Tillable`**: Defines items (hoes) that can turn blocks into farmland.
*   **`Waxable` / `Weatherable`**: Handles honeycomb interactions and Copper oxidation/aging logic.

## 4. Key Purpur Methods & Mixins

Purpur adds extra methods directly to Entities via its API:
*   `entity.setRidable(boolean)`: Make any entity rideable.
*   `entity.setControllable(boolean)`: Allow players to control the entity with WASD.

## 5. NMS & Core Modifications 🫀

*   **`StoredEntity`**: Purpur's NMS `Entity` implementation allows persistent data access directly on the NMS object, bypassing some Bukkit overhead.
*   **Mob AI (Brain)**: Purpur patches classes like `MobGoalHelper`. For example, `RangedBowAttackGoal` allows configuring attack intervals (machine-gun skeletons).
*   **Performance Monitoring**: Internal tasks like `TPSBarTask` and `RamBarTask` read server ticks and memory directly to display BossBars.

## 6. Component Logger 📝

Purpur (and Paper) enforces the modern logging standard.
**DO NOT USE:** `System.out.println` or `Bukkit.getLogger()`.
**USE:**
```java
componentLogger.info(Component.text("Purpur logic initialized.").color(NamedTextColor.LIGHT_PURPLE));
```

## 7. Configuration Files 📂

Located in `packages/minecraft/`:
*   `purpur.yml`: The main configuration for Purpur-specific features.
*   `paper-global.yml` / `paper-world-defaults.yml`: Parent configuration files from Paper.

## 8. Useful Links 🔗
*   **Javadoc**: [https://purpurmc.org/javadoc](https://purpurmc.org/javadoc)
*   **Docs**: [https://purpurmc.org/docs](https://purpurmc.org/docs)
*   **GitHub**: [https://github.com/PurpurMC/Purpur](https://github.com/PurpurMC/Purpur)