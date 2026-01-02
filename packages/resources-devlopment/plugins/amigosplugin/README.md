# 🧠 Amigos Plugin

**The Server Brain.** ⚙️

This is the custom Minecraft plugin for **Amigos Do Mine**. It handles all the server-side logic, custom events, and integrations with the Backend API.

## 🛠️ Tech Stack

*   **Platform:** [Paper/Purpur API](https://purpurmc.org/) (1.21.8+)
*   **Language:** Kotlin (JVM 21)
*   **Build System:** Gradle (Kotlin DSL)

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
│   │   └── com/tupynambalucas/amigosdomine/
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

| Command | Permission | Description |
| :--- | :--- | :--- |
| `/amigos` | `N/A` | Simple test command to verify plugin is active. |
| `/setspawn` | `amigos.admin.setspawn` | Sets the world spawn point at your location. |
| `/spawn` | `amigos.spawn` | Teleports you to the defined spawn point. |
| `N/A` | `amigos.chat.color` | Allows using MiniMessage (e.g. `<red>`, `<rainbow>`) in chat. |

## ⚠️ Notes
*   **Vulnerability Fix:** We force `commons-lang3:3.20.0` to avoid CVE-2025-48924.
*   **Naming:** The plugin name is `AmigosPlugin`.