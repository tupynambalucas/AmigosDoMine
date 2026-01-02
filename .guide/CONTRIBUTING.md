# 🤝 Contributing Guidelines

Yo! Welcome to the team! 👋
We are super stoked you want to help build **Amigos Do Mine**. We run a tight ship with our monorepo, so here is the lowdown on how to contribute without breaking everything.

## 1. Quick Start ⚡

### What You Need

- **Node.js**: v20+ (The engine).
- **Docker**: Desktop or Engine + Compose (The playground).
- **Java**: JDK 21 (Only if you are touching Kotlin code).

### Spin It Up

```bash
# Clone this beauty
git clone https://github.com/tupynambalucas/AmigosDoMine.git
cd AmigosDoMine

# Install the goods
npm install

# Wake up the database & redis
npm run infra:up
```

## 2. How We Work 🛠️

We use **NPM Workspaces**, so you can run scripts from the root and they magically work in the right folder.

- `npm run dev:stack`: Fires up the Backend and Frontend.
- `npm run dev:minecraft`: Launches the game server (Dockerized).
- `npm run build:all`: Checks if you broke any types.
- `npm run infra:reset`: **Danger Zone!** Wipes the DB and starts fresh.

### The "Golden Rule" of Types 📜

If you need a new data type (like a `PlayerProfile`), **DO NOT** write it in the frontend or backend folders.

1.  Go to `@amigos-do-mine/shared`.
2.  Define it there using Zod.
3.  Import it everywhere else.
    This keeps us sane and type-safe!

## 3. Asset & Code Hygiene 🧹

- **Language**: Code and Commits in **English**. (We love Portuguese, but the code speaks English).
- **Naming**:
  - TS Files: `camelCase.ts`
  - Textures: `snake_case.png` (Minecraft hates capital letters in files).
- **Assets**: Don't manually dump files in `backend/public`. Use the `resources-devlopment` pipeline. It's there for a reason!

## 4. Submitting Your Art 🎨

1.  Run `npm run lint` (Make it pretty).
2.  Run `npm run typecheck:all` (Make it work).
3.  Open a Pull Request and tell us what cool stuff you added!

> _Need the nitty-gritty rules? [STYLEGUIDE.md](./STYLEGUIDE.md) is the law._
