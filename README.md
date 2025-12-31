# Amigos Do Mine - Integrated Ecosystem

## 🎮 About the Project

**Amigos Do Mine** is a professional-grade monorepo designed to synchronize a high-performance Minecraft server (Purpur) with a modern web management infrastructure. It provides a full-stack solution for server owners, covering everything from asset creation to automated deployment and web-based player management.

## 🏗 Modular Architecture

The project is structured into modular workspaces:

- **`@elo-organico/backend`**: Fastify v5 API Gateway and Asset Host.
- **`@elo-organico/frontend`**: React 19 Management Portal.
- **`@elo-organico/shared`**: SSOT for Schemas, Contracts, and Constants.
- **`packages/minecraft`**: Containerized JRE 21 Game Server environment.
- **`packages/minecraft-resources`**: Development workspace for Textures, Models, and Assets.

## 🚀 Environment Execution

| Task                  | Command                                         |
| :-------------------- | :---------------------------------------------- |
| **Start Databases**   | `npm run infra:up`                              |
| **Development Mode**  | `npm run dev:stack` & `npm run dev:minecraft`   |
| **Build Assets**      | `npm run build -w packages/minecraft-resources` |
| **Production Launch** | `npm run prod:up`                               |

## 📦 Asset Management Lifecycle

1.  **Creation**: Designers work within `packages/minecraft-resources`.
2.  **Staging**: Assets are bundled and moved to the **Backend** public storage.
3.  **Delivery**: The Backend serves the resource pack to the **Minecraft** server via a secured URL.
4.  **Verification**: The game server validates the pack hash before prompting players to download.

## 🛡 Security & Hardening

- **User Isolation**: In production, the game server process runs under a restricted `minecraft` user.
- **Monitoring**: Integrated `eudev-libs` resolves system monitoring warnings (OSHI).
- **Persistence**: Bind Mounts ensure that worlds, player data, and configurations in `packages/minecraft` are never lost.

## 📜 Key Automation Scripts

- `npm run dev:minecraft`: Builds and starts the server with latest `Dockerfile` changes.
- `npm run infra:reset`: Purges all infrastructure data for a clean slate.
- `npm run lint:all`: Executes static code analysis across the monorepo.

---

Developed by **Tupynambá Lucas**
