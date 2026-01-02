# IA_STYLEGUIDE - Master Engineering Standards

**Listen up, AI Assistants!** 🤖
This is your primary directive. When you are writing code for **Amigos Do Mine**, these rules are not suggestions—they are the law.

## 1. The Prime Directives 🛡️

*   **SSOT or Die**: Never, ever use `any`. All data shapes must come from `@amigos-do-mine/shared`. If a type is missing, create it there first.
*   **Asset Safety**: Do not touch raw assets in `backend`. Always edit in `packages/resources-devlopment` and use the build pipeline.
*   **Async Everything**: Java I/O (file reads, web requests) on the game server MUST be asynchronous. If you block the main thread, the server lags, and players cry.

## 2. Minecraft Resource Rules 🎨
(`packages/resources-devlopment`)

*   **Naming is Key**:
    *   ✅ `ruby_sword.png`
    *   ❌ `RubySword.png` (This will break the game!)
*   **Organization**: Keep textures in `/textures` and models in `/models`. Don't be messy.
*   **Exporting**: Always use the build script to zip it up.

## 3. Docker Do's and Don'ts 🐳

*   **User Permissions**: In production, we run as `user: minecraft`. Don't assume you have root.
*   **Signals**: Use `exec` form in Dockerfiles so the server shuts down gracefully (SIGTERM).
*   **Build It**: If you change the Dockerfile (like adding `eudev-libs`), run with `--build`.

## 4. Backend & Security 🔐

*   **Verify Integrity**: The backend isn't just a file server; it validates SHA-1 hashes for resource packs.
*   **Zod is King**: Every API request needs a Zod schema validation. Trust nothing.

## 5. Culture & Language 🗣️

*   **Code**: Technical English always.
*   **Soul**: The project name is **Amigos Do Mine** (Portuguese). That stays.
*   **Vibe**: Professional code, fun product.

> *Now go forth and code responsibly!*
