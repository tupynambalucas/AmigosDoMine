# 🏗️ AmigosPlugin Architecture

## 🌍 Overview
The **AmigosPlugin** is the central nervous system of the Amigos Do Mine Minecraft server. It is built on the **Purpur API** (a fork of Paper) and serves as the bridge between the in-game experience and the external backend services.

## 📦 Package Structure
The codebase follows a strict domain-driven design within the `com.tupynambalucas.mine.purpur` namespace.

```text
com.tupynambalucas.mine.purpur
├── features/          # Self-contained business logic modules
│   ├── essentials/    # Basic server commands (Spawn, Warps)
│   └── magic/         # Integration with MagicPlugin
├── mechanics/         # Core game mechanics modifications
│   └── chat/          # Chat formatting and handling
├── commands/          # Global/General commands
├── listeners/         # Global event listeners
├── utils/             # Helper classes and extensions
└── AmigosPlugin.kt    # Main Entry Point & Lifecycle Management
```

## 🧩 Key Components

### 1. Features
Features are independent modules that encapsulate specific functionality. They usually consist of:
*   **Commands**: Input handling (e.g., `/setspawn`).
*   **Services**: Business logic (e.g., `SpawnService` saving to config).
*   **Listeners**: Feature-specific event handling.

**Example: Essentials Feature**
*   `EssentialsFeature.kt`: Registration entry point.
*   `SpawnService.kt`: Logic for handling spawn locations.

### 2. Mechanics
Mechanics alter how the base game behaves. Unlike features, which are usually "opt-in" (commands), mechanics often run passively.
*   **Chat**: Intercepts chat packets to format messages using MiniMessage.

### 3. Integrations
*   **MagicPlugin**: We directly integrate with the `Magic` plugin API. To ensure safety, we use an **Adapter Pattern** (`MagicAdapter`). If Magic is missing, the adapter fails gracefully, and the server continues to run without magic features.

## 🔄 Data Flow

1.  **Input**:
    *   **Player Command**: `/spawn`
    *   **Game Event**: `PlayerJoinEvent`
2.  **Processing**:
    *   **Command Handler** (Paper Brigadier) validates permissions.
    *   **Service Layer** executes logic (e.g., finding the location).
3.  **Output**:
    *   **Game Action**: Teleport player.
    *   **Feedback**: Send MiniMessage component to chat.

## 🛡️ Standards
*   **Dependency Injection**: Dependencies (like `SpawnService`) are injected into Commands, not instantiated inside them.
*   **MiniMessage**: All text sent to players MUST use the MiniMessage format (`<red>Error!`).
*   **Safe Config**: Configuration access is wrapped in Services, never accessed directly by commands.
