# 🏗️ System Architecture

Alright, let's pop the hood and see what's powering this beast. 🔧

**Amigos Do Mine** is a monorepo, which means all our cool toys live in one big happy house. We use a **Single Source of Truth (SSOT)** strategy—basically, if a data type exists, it's defined in one place (`shared`) so the Backend and Frontend never get confused.

## 1. The Squad (Packages) 🧱

We manage everything with NPM Workspaces. Here's the lineup:

1.  **`@amigos-do-mine/backend`**: The Brain. A blazing fast **Fastify v5** API. It handles auth, data, and serves the resource packs.
2.  **`@amigos-do-mine/frontend`**: The Face. A **React 19** SPA that looks pretty and lets you control the chaos.
3.  **`@amigos-do-mine/shared`**: The Law. **Zod** schemas and Types that everyone must obey.
4.  **`packages/minecraft`**: The Playground. A dockerized **Purpur 1.21+** server.
5.  **`packages/resources-devlopment`**: The Studio. Where we cook up custom plugins (`plugins/amigosplugin`) and assets (MCreator).

## 2. How It Connects (Topology) 🕸️

### 2.1. The API Gateway (`backend`)
*   **Tech**: Node.js v20+, Fastify v5, MongoDB v7.
*   **Job**: It's the traffic controller. It talks to the database, caches stuff in Redis, and acts as a CDN for our game assets.
*   **Special Skill**: It hosts the `.zip` resource packs so the game server can tell players where to download them.

### 2.2. The Game Server (`minecraft`)
*   **Tech**: Java 21 (Eclipse Temurin) running Purpur.
*   **Integration**: It runs our custom "Amigos Plugin". This plugin talks to the backend to say "Hey, is this player allowed in?" or "Here is the latest resource pack URL."
*   **Hardware Access**: We map `eudev-libs` in the container so we can monitor hardware stats (OSHI) directly from the game console.

### 2.3. The Data Flow (SSOT)
The **`shared`** package is the boss.
*   If you want to add a `User` field, you add it in `shared`.
*   The Backend imports it to validate the API request.
*   The Frontend imports it to type-check the form.
*   **Result**: Zero crashes caused by "undefined is not a function".

## 3. The "Develop-Host-Consume" Flow ♻️

This is our secret sauce for assets:

1.  **Cook**: You make a cool 3D sword in `resources-devlopment`.
2.  **Pack**: Our scripts bundle it into a `.zip`.
3.  **Serve**: The file moves to the `backend`'s public folder.
4.  **Eat**: The `minecraft` server sees the update and tells every connected player to download the new pack automatically.

## 4. Infrastructure & Docker 🐳

We run on a unified network called `amigosdomine_network`.

*   **Persistence**:
    *   **Minecraft**: Uses Bind Mounts (`./packages/minecraft:/data`) so you can easily edit server files from your host.
    *   **Databases**: Use Named Volumes (`mongo_data`) because we don't want to touch raw DB files.
*   **Security**: In production, the Minecraft container runs as a restricted `minecraft` user. No running as root!
*   **Networking**:
    *   Locally, you hit `localhost:3000`.
    *   Inside the docker network, services talk to `http://backend:3000`.

> *Want to contribute? Head over to [CONTRIBUTING.md](./CONTRIBUTING.md) to get your hands dirty.*