# Amigos Do Mine - Integrated Technical Context

## 1. Project Vision

**Amigos Do Mine** is a sophisticated digital ecosystem architected to bridge the gap between Java-based game engines (Minecraft/Purpur) and modern web infrastructures (Fastify v5 / React 19). The project operates as a high-performance monorepo using **NPM Workspaces**, ensuring a **Single Source of Truth (SSOT)** for data schemas, authentication, and asset management across all packages.

## 2. System Architecture & Topology

### 2.1 Package Domains

- **`@elo-organico/shared`**: The immutable core. It centralizes Zod schemas and TypeScript interfaces to prevent runtime data drift between the API and the Client.
- **`@elo-organico/backend`**: A scalable Fastify v5 gateway. Beyond business logic and persistence, it serves as the **Asset Distribution Hub**, hosting and providing resource packs via specialized endpoints for in-game consumption.
- **`@elo-organico/frontend`**: A React 19 SPA optimized with Vite. It features a reactive UI powered by Zustand and TailwindCSS v4 for administrative control.
- **`packages/minecraft`**: A stateful Purpur server environment. It consumes resources served by the backend and maintains game state with high-performance configurations.
- **`packages/minecraft-resources` (Creative Layer)**: The dedicated environment for developing textures, 3D models (items/blocks), and custom configurations. Assets developed here are staged for deployment to the Backend's distribution layer.

### 2.2 Resource Distribution Lifecycle

The ecosystem implements a "Develop-Host-Consume" lifecycle:

1.  **Development**: Creative assets are built and versioned in `packages/minecraft-resources`.
2.  **Hosting**: Finalized resource packs are imported by the **`backend`**, which exposes an endpoint (e.g., `/api/v1/resources/download`) to serve the files.
3.  **Consumption**: The **`minecraft`** server uses specialized plugins to fetch these packs from the network, ensuring all players have synchronized assets.

## 3. Infrastructure & Security Matrix

- **Data Persistence**: Managed through **Docker Bind Mounts** for the Minecraft server (`./packages/minecraft:/data`) and **Named Volumes** for databases (`mongo_data`, `redis_data`).
- **Container Hardening**: In Production, services run under non-privileged users. The Minecraft process is restricted to a `minecraft` system user.
- **OS-Level Dependencies**: Includes `eudev-libs` within the Alpine environment to support OSHI hardware monitoring.

## 4. Communication Protocols

- **Internal Networking**: Services communicate over the `amigosdomine_network` bridge.
- **API Resolution**:
  - **Development**: Resources are accessed via `http://localhost:3000`.
  - **Production**: Resources are accessed via `http://backend:3000` or the public domain.
