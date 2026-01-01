# 🏰 Amigos Do Mine - Game Server

**The Playground.** ⛏️💎

This is the beating heart of the game. We run a highly optimized **Purpur** server (Minecraft 1.21+) inside a Docker container. It's safe, isolated, and easy to reset.

## 📦 Container Specs

We take performance seriously.
*   **Core:** Eclipse Temurin (Java 21) ☕
*   **Server:** Purpur (Optimized fork of Paper)
*   **Security:** Runs as non-root `minecraft` user in production. 🛡️

## 📂 Data Persistence

Don't worry, your diamond armor is safe. We use Docker Volumes:
*   `./data`: Maps to the container's `/data` folder.
*   **Worlds, Players, and Plugins** are all persisted on your host machine.

## 🚀 How to Launch

You don't need to install Java locally! Just use Docker.

```bash
# From the project root:
npm run dev:minecraft
```

This command will:
1.  Build the custom Docker image.
2.  Install necessary libraries (`eudev-libs` for hardware monitoring).
3.  Launch the server and attach to the console.

## 🧩 Plugins & Configs

*   **Third-Party Plugins:** Place `.jar` files in `plugins/`.
*   **Amigos Plugin:** Our custom logic lives in `packages/minecraft-resources`. Build it there, and it will be deployed here! 🧠
*   **Configs:** Tweak `config/` files as needed.

> **Note:** The Dockerfile handles the setup during the build/startup phase.