# 🧠 Amigos Plugin

**The Server Brain.** ⚙️

This is the custom Minecraft plugin for **Amigos Do Mine**. It handles all the server-side logic, custom events, and integrations with the Backend API.

## 🛠️ Tech Stack

- **Platform:** [Paper/Purpur API](https://purpurmc.org/) (1.21.8+)
- **Language:** Kotlin (JVM 21)
- **Build System:** Gradle (Kotlin DSL)
- **Magic Integration:** Runtime integration with the Magic plugin via `MagicAPI` (marked as `compileOnly`). Magic features are enabled only when the Magic plugin is present on the server; the plugin degrades gracefully when Magic is absent.

## 📐 Architecture & Standards

We strictly adhere to **SOLID Principles** to ensure the codebase remains maintainable, testable, and scalable.

- **S - Single Responsibility:** Each class and feature module should have one distinct purpose. (e.g., separate `SpawnCommand` logic from `SetSpawnCommand` logic).
- **O - Open/Closed:** Features should be open for extension but closed for modification. Use interfaces and events.
- **L - Liskov Substitution:** Implementations must fulfill the contracts of their interfaces without breaking behavior.
- **I - Interface Segregation:** Prefer small, specific interfaces over monolithic ones.
- **D - Dependency Inversion:** High-level modules should not depend on low-level modules. Both should depend on abstractions.

### Feature Modules

We organize code by **Feature** rather than by technical layer.

- ✅ `features/essentials/spawn/SpawnCommand.kt`
- ❌ `commands/SpawnCommand.kt`

## 🚀 Development Setup

### IntelliJ IDEA (Recommended)

1.  Open this folder (`packages/resources-devlopment/plugins/amigosplugin`) as a project.
2.  Let Gradle sync dependencies.
3.  Write code in `src/main/kotlin`.

### Building

To compile the plugin into a `.jar`:

```bash
./gradlew shadowJar
```

The output will be placed in:
`../../build/plugins/AmigosPlugin.jar`

## 📦 Project Structure

```text
src/
├── main/
│   ├── kotlin/
│   │   └── com/tupynambalucas/mine/purpur/
│   │       ├── features/          # Feature modules (e.g., essentials, economy)
│   │       │   └── essentials/    # Spawn, Warp, etc.
│   │       ├── mechanics/         # Core mechanics (e.g., Chat Formatting)
│   │       │   └── chat/
│   │       ├── commands/          # General/Core commands
│   │       └── AmigosPlugin.kt    # Main Entry Point
│   └── resources/
│       └── paper-plugin.yml       # Manifest
```

## 🎮 Commands & Permissions

| Command     | Permission              | Description                                                   |
| :---------- | :---------------------- | :------------------------------------------------------------ |
| `/amigos`   | `N/A`                   | Simple test command to verify plugin is active.               |
| `/setspawn` | `amigos.admin.setspawn` | Sets the world spawn point at your location.                  |
| `/spawn`    | `amigos.spawn`          | Teleports you to the defined spawn point.                     |
| `N/A`       | `amigos.chat.color`     | Allows using MiniMessage (e.g. `<red>`, `<rainbow>`) in chat. |

## ⚠️ Notes

- **Vulnerability Fix:** We force `commons-lang3:3.20.0` to avoid CVE-2025-48924.
- **Naming:** The plugin name is `AmigosPlugin`.
