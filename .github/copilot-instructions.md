---
applyTo: '**'
---

# Project Context & Standards

You are assisting with the **Amigos Do Mine** project. You must strictly adhere to the documentation found in the project root.

## Critical Documentation
1.  **`IA_CONTEXT.md`**: Refer to this file for the System Architecture, Package Domains, and Infrastructure topology.
2.  **`IA_STYLEGUIDE.md`**: Refer to this file for Engineering Standards, Naming Conventions, and Type Safety rules.

## Key Directives (Summary)
-   **Single Source of Truth**: All shared types and schemas live in `@amigos-do-mine/shared`. Never redefine them.
-   **Type Safety**: Strict usage of Zod and TypeScript. No `any`.
-   **Asset Pipeline**: Assets flow from `minecraft-resources` (creation) -> `backend` (hosting) -> `minecraft` (consumption).
-   **Language**: Code and technical docs in English. Project identity in Portuguese.

Please read `IA_CONTEXT.md` and `IA_STYLEGUIDE.md` to fully understand these requirements before generating code.