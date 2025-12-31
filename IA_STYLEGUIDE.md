# IA_STYLEGUIDE - Master Engineering Standards for Amigos Do Mine

## 1. Explicit AI Directives

Any AI assistant interacting with **Amigos Do Mine** must adhere to these non-negotiable standards:

- **Asset Integrity**: Never modify raw assets in `packages/minecraft-resources` without verifying the export path to the `backend` hosting directory.
- **Type Integrity**: No usage of `any`. All data shapes must derive from `@elo-organico/shared`.
- **Async Integrity**: All Java-based I/O (specifically fetching resource packs or API calls) must be asynchronous to maintain server TPS.

## 2. Resource & Asset Standards (`packages/minecraft-resources`)

- **Naming Conventions**:
  - Texture Files: `snake_case.png` (e.g., `ruby_sword.png`).
  - Model Files: `snake_case.json` (e.g., `custom_shield.json`).
- **Structure**: Assets must be organized by category (e.g., `/textures`, `/models`, `/lang`).
- **Export Process**: The package must include a build script to bundle assets into a `.zip` file and move it to the `backend` public directory or storage provider.

## 3. Docker & Container Standards

- **Production User**: Always specify `user: minecraft` in production-grade compose files.
- **Build Management**: Use the `--build` flag during development (`npm run dev:minecraft`) to ensure `Dockerfile` changes (like `eudev-libs` or user creation) are reflected.
- **Signal Handling**: Commands must use the `exec` form to ensure the JVM receives termination signals (SIGTERM) correctly.

## 4. Backend & Shared Logic

- **Resource Hosting**: The backend must implement a secure endpoint for resource pack distribution, utilizing hash verification (SHA-1) to ensure file integrity on the Minecraft client.
- **Validation**: Every request must be parsed via Zod Schemas defined in the shared package.

## 5. Documentation & Language

- **Technical English**: All code, documentation, and architectural discussions must be in English.
- **Project Identity**: The project name **Amigos Do Mine** must remain in Portuguese.
