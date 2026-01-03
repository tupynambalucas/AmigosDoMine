# Migration Plan — Use Magic API Only (No Merge into Amigos)

Goal

- Stop converting/transferring the Magic plugin into the master plugin.
- Integrate with Magic by depending solely on its public API (`MagicAPI`) as a compileOnly/provided dependency and using runtime checks to enable features when Magic is present.
- Keep integration incremental, reversible, and safe for Purpur 1.21.11 on Java 21.

Scope & relevant paths

- Consume the API described in [resources/amigosplugin/MAGIC_API.md](resources/amigosplugin/MAGIC_API.md) (`MagicAPI`).
- Plugin sources remain in:
  - `resources/amigosplugin/Amigos` — our master plugin code that will _call_ Magic API when available.
  - Magic remains a separate plugin artifact (no code move).
- Purpur guidance: [resources/amigosplugin/PURPUR_DOC.md](resources/amigosplugin/PURPUR_DOC.md), [resources/amigosplugin/PURPUR_API_OVERVIEW.md](resources/amigosplugin/PURPUR_API_OVERVIEW.md).

High-level phases

1. Preparation
   - Pin Purpur API to 1.21.11 in Amigos Gradle files (same as described in [PURPUR_DOC.md](resources/amigosplugin/PURPUR_DOC.md]).
   - Ensure Kotlin jvmToolchain = 21 and shadowJar outputs remain unchanged.
   - Add CI job to build plugins and run basic startup smoke tests (see CI recommendations below).

2. Stabilize Magic as a runtime dependency
   - Add Magic API as compileOnly/provided in Amigos:
     - Gradle: compileOnly("com.elmakers.mine.bukkit", "MagicAPI", "10.2")
   - Implement an internal adapter/service in Amigos that locates and wraps `MagicAPI` at runtime (safe null checks).
   - Do NOT copy Magic internals; only reference public API contracts from [MAGIC_API.md](resources/amigosplugin/MAGIC_API.md).

3. Incremental feature integration (adapter-first)
   - For each feature we want to integrate (only in-scope examples listed in original plan), implement:
     - A capability check that verifies Magic plugin is loaded and `instanceof` `MagicAPI`.
     - A thin adapter that translates Amigos calls to Magic API calls.
     - Fallback behavior (graceful degradation) when Magic is absent.
   - Keep Magic jar available until validation is complete.

4. Finalize approach
   - Do not remove Magic plugin artifact (we never merge code). Only remove compileOnly dependency if/when Magic is no longer desired.
   - Centralize adapter code in `resources/amigosplugin/Amigos/src/main/kotlin/.../magic/Adapter.kt`.

Runtime adapter example (Kotlin)

```kotlin
// Example adapter snippet — put in Amigos adapter module
fun getMagicApi(): MagicAPI? {
    val plugin = server.pluginManager.getPlugin("Magic") ?: return null
    return if (plugin is MagicAPI) plugin as MagicAPI else null
}

class MagicAdapter(private val api: MagicAPI) {
    fun spawnCustomMob(type: String, loc: Location) {
        // call MagicAPI methods safely
        api.spawnMob(type, loc)
    }
}
```
