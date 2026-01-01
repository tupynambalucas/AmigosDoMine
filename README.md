# 🌲 Amigos Do Mine - The Ecosystem

**Welcome to the ultimate Minecraft integration suite!** 🎮✨

**Amigos Do Mine** isn't just a server; it's a sophisticated, professional-grade monorepo that bridges the gap between the blocky world of **Minecraft (Purpur)** and modern web tech. We're talking about a seamless flow from asset creation to in-game delivery, managed by a high-performance web dashboard.

Whether you're here to code, build, or play, you're in the right place!

---

## 🏗️ The Architecture (How it flows)

We use **NPM Workspaces** to keep everything cozy under one roof. Here's the squad:

| Package | Role | Tech Stack |
| :--- | :--- | :--- |
| **`backend`** | 🧠 The Brain | **Fastify v5**, MongoDB, Redis. Serves assets & API. |
| **`frontend`** | 💅 The Face | **React 19**, TailwindCSS v4, Zustand. The admin dashboard. |
| **`shared`** | 🤝 The Truce | **Zod**, TypeScript. Ensures Backend and Frontend speak the same language. |
| **`minecraft`** | 🏰 The Castle | **Purpur 1.21+**, Docker. The actual game server environment. |
| **`minecraft-resources`** | 🎨 The Studio | **Kotlin** & **MCreator**. Home of the Master Plugin & Resource Pack. |

---

## 🚀 Quick Start

Ready to lift off? Here is how you get the whole stack moving.

### Prerequisites
*   Node.js v20+
*   Docker & Docker Compose
*   Java 21 (For Plugin Development)

### Commands
Run these from the root directory:

```bash
# 1. Wake up the infrastructure (Database, Redis, etc.)
npm run infra:up

# 2. Start the Development Stack (Backend + Frontend)
npm run dev:stack

# 3. Fire up the Minecraft Server
npm run dev:minecraft
```

> **💡 Pro Tip:** Check `packages/minecraft-resources` to learn how to compile the custom plugin and textures!

---

## 🛡️ Style & Philosophy

We follow a strict **"Single Source of Truth"** policy.
*   **Type Safety:** We don't guess types; we define them in `@amigos-do-mine/shared`.
*   **Asset Integrity:** Textures start in `minecraft-resources`, move to `backend`, and land in `minecraft`.
*   **Language:** We code in **English**, but our heart (and project name) is in **Portuguese**.

---

Developed with 💜 by **Tupynambá Lucas**
