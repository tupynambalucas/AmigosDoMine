# 🧠 Amigos Do Mine - Backend

**The Engine Room of the Ecosystem.** ⚙️🔥

Welcome to the backend! This isn't your average API. We are running on **Fastify v5**, making it blazingly fast and efficient. This service handles everything from player authentication to serving the custom resource packs that make our server unique.

## 🛠️ The Tech Stack

*   **Runtime:** Node.js v20+ (The powerhouse)
*   **Framework:** [Fastify v5](https://www.fastify.io/) (Because speed matters)
*   **Database:** MongoDB v7 (Mongoose for modeling)
*   **Caching:** Redis (Keeping things snappy)
*   **Validation:** Zod (Trust, but verify)
*   **Tasks:** BullMQ (For the heavy lifting in the background)

## 📂 Architecture

We keep things tidy with **Domain-Driven Design (DDD)**. No spaghetti code here! 🍝❌

```text
src/
├── config/       # ⚙️ Knobs and dials (Env, Fastify setup)
├── domains/      # 📦 Business logic lives here
│   ├── auth/     # Security checks
│   └── product/  # Item management
├── plugins/      # 🔌 Fastify superpowers (DB, Auth, Sentry)
└── utils/        # 🛠️ Handy tools
```

## 🏃‍♂️ How to Run

Since you are in a monorepo, you can run this easily:

```bash
# Start in Development Mode (Watch & Respawn)
npm run dev

# Build for Production
npm run build
npm run start
```

## 🔐 Environment Variables

Make sure you have your `.env` ready!

```properties
# Basics
NODE_ENV=development
SERVER_PORT=3000

# Connectivity
MONGO_URI=mongodb://...
REDIS_HOST=localhost
```

> **Note:** This service acts as the **Asset Host**. It exposes endpoints so the Minecraft server can download the latest resource packs automatically. 📦➡️🏰
