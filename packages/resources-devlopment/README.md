# 🎨 Amigos Do Mine - Creative Studio

**Where Logic Meets Magic.** 🧠✨

Welcome to the creative heart of the ecosystem. This workspace is unique because it houses two distinct powerhouses: the **Master Plugin** (Server Logic) and the **Resource Pack** (Visuals).

Whether you are compiling Kotlin or painting pixels, this is your home.

## 📂 The Dual Structure

We split the work into two dedicated development environments inside this folder:

| Folder | Purpose | Tooling | Output |
| :--- | :--- | :--- | :--- |
| **`plugins/amigosplugin`** | 🧠 **Server Brain:** Custom mechanics, commands, events, and features like Essentials. | **IntelliJ IDEA** (Kotlin/Gradle) | `build/plugins/` |
| **`resourcepack`** | 🎭 **Server Face:** 3D models, textures, sounds, and UI. | **MCreator** | `build/resourcepack/` |

---

## 🧠 1. The Amigos Plugin (`plugins/amigosplugin`)

This is the custom logic that makes our server unique. It's built with **Kotlin** running on **Paper/Purpur API**.

### 🛠️ Tech Stack
*   **Language:** Kotlin (JVM 21) ☕
*   **Build System:** Gradle (Kotlin DSL)
*   **Shadowing:** We bundle our deps using `ShadowJar`.

### 🚀 How to Build
Open `plugins/amigosplugin` in IntelliJ IDEA.

```bash
# From packages/resources-devlopment/plugins/amigosplugin
./gradlew build
```

**The Magic:** The `build.gradle.kts` is configured to automatically output the compiled jar to:
`../../build/plugins/AmigosPlugin.jar`

---

## 🎭 2. The Resource Pack (`resourcepack`)

This is where we redefine the look of Minecraft. We use **MCreator** to empower creators to build without complex coding.

### 🛠️ Tech Stack
*   **Tool:** MCreator (Open Source Mod Generator)
*   **Target:** Minecraft Java Edition Resource Pack

### 🚀 How to Export
1.  Open your workspace in **MCreator**.
2.  Design your custom blocks, items, and GUIs.
3.  **Export to Folder:** Select the export option that generates the raw files.
4.  **Target:** Ensure the output goes to `packages/resources-devlopment/build/resourcepack/`.

---

## ⚙️ The Deployment Pipeline

Once assets are built, they don't stay here. They are destined for the **Backend**.

1.  **Build Phase:**
    *   Plugin ➡️ `build/plugins/`
    *   Textures ➡️ `build/resourcepack/`
2.  **Distribution Phase:**
    *   The **Backend** picks up these artifacts to host them for the game server (Resource Pack Hosting) or for deployment scripts.

## ⚠️ Golden Rules

*   **Snake_case Only:** Files must be `ruby_sword.png`, never `RubySword.png`.
*   **Clean Builds:** Always run a `clean` task in Gradle before a production release.
*   **MCreator Hygiene:** Keep your MCreator workspace organized. Use folders!

> **Fun Fact:** By decoupling the plugin logic from the main server folder, we ensure that our custom code is version-controlled and distinct from third-party plugins! 🛡️