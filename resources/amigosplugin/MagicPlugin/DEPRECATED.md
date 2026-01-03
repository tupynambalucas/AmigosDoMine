# Deprecated / Removed Features (summary)

This document summarizes notable features, configuration keys, actions and behaviours that have been deprecated or removed from Magic and its related modules.

Use the linked migration notes and changelogs for exact upgrade steps and version-specific context.

Key removals and renames

- Automata (historical): the older experimental "Automata" systems and some example automata spells were reworked or relocated. See `Magic/AUTOMATA.md` for current status and guidance.
- Example configs: several older example sets (notably example 6 and 7 in distributed defaults) are no longer shipped by default — re-add manually if needed.
- Spell/action replacements and renames:
  - `RecallSpell` → replaced by `RecallAction` (use action-based configs).
  - Action renames and consolidations: `Iterate` → `Line`, `ReplaceMaterial` → `ModifyBlock`, `CoverAction` → `Disc`/`Cover`, and similar parameter/name changes across actions.
- Wand and wand-property changes:
  - `attributes` renamed to `item_attributes`.
  - `mob` / `entity attributes` renamed to `entity_attributes`.
  - `mode_drop` wand property removed; use stash-related options or explicit wand behaviors instead.
  - `wand_enchantable_item` default behavior changed — explicitly set this in wand configs if required.
- Configuration and parameter removals:
  - `add_uses` path parameter removed; use `uses` instead.
  - `auto_undo` global config deprecated: undo behavior is now managed per-spell.
  - `sp_display` global setting removed: wand-level SP/XP display configuration is used instead.
- Resource pack / RP changes: resource pack format and sending behavior were updated for modern Minecraft versions (including format bumps for 1.20+). Review resource-pack settings when upgrading.
- Integration and compatibility notes: integrations (WorldGuard, MythicMobs, EffectLib, etc.) and some internal APIs have experienced breaking changes across versions—consult changelogs for compatibility requirements.

Migration & references

- Primary migration guide: `Magic/MIGRATION.md` — review this first when upgrading configs or examples.
- Changelog: `Magic/CHANGELOG.md` — for per-version fixes and behaviour changes that may affect server setups.
- Automata: `Magic/AUTOMATA.md` — notes and warnings about automata behaviour and experimental status.
- API-level changes: `MagicAPI/README.md` — for plugins depending on MagicAPI.

Recommendations

- Audit custom `examples/*`, `paths/*`, and `wands.*` config files for the keys and action names listed above before upgrading a production server.
- Test upgrades on a staging server; convert deprecated keys to their modern equivalents using `MIGRATION.md` guidance.

For full details and historical context, consult the files in this module and the upstream changelogs.

# Deprecated / Removed Features (summary)

This file lists notable features, config keys and behaviours that have been deprecated or removed from Magic and related modules. See the referenced docs for migration notes.

- `Automata` (rebranded / moved) — replaced by "Magic Blocks" / moved out of default examples. See [`Automata`](Magic/MAGIC/AUTOMATA.md) and migration notes in [`Magic/MIGRATION.md`](Magic/MIGRATION.md).
- Default example files 6 and 7 — removed from distributed examples; re-add manually if needed. See [`Magic/MIGRATION.md`](Magic/MIGRATION.md).
- `RecallSpell` — removed; use `RecallAction` instead. See [`Magic/MIGRATION.md`](Magic/MIGRATION.md).
- Wand/class property renames:
  - `attributes` -> `item_attributes`
  - `mob/entity attributes` -> `entity_attributes`
    Update configs accordingly. See [`Magic/MIGRATION.md`](Magic/MIGRATION.md).
- `mode_drop` wand property — removed (use stash/related options). See migration notes in [`Magic/MIGRATION.md`](Magic/MIGRATION.md).
- `add_uses` path parameter — removed; use `uses`. See [`Magic/MIGRATION.md`](Magic/MIGRATION.md).
- `auto_undo` global config — deprecated; undo behavior moved to individual spells. See [`Magic/MIGRATION.md`](Magic/MIGRATION.md).
- `sp_display` global setting — removed; wand SP/xp displays moved to wand-level config. See [`Magic/MIGRATION.md`](Magic/MIGRATION.md).
- Resource pack defaults / format changes — RP sending behavior and format updated (pack format and default auto-send toggles). See [`Magic/MIGRATION.md`](Magic/MIGRATION.md) and [`Magic/CHANGELOG.md`](Magic/CHANGELOG.md).
- `wand_enchantable_item` default change — behavior changed; add explicit config if required. See [`Magic/MIGRATION.md`](Magic/MIGRATION.md).
- Various action/parameter renames (examples):
  - `Iterate` -> `Line`
  - `ReplaceMaterial` -> `ModifyBlock`
  - `CoverAction` -> `Disc`/`Cover`
    Review action-based spell configs. See [`Magic/MIGRATION.md`](Magic/MIGRATION.md).

For full history and finer-grained removals, consult the changelogs and migration guide:

- [Magic MIGRATION.md](Magic/MIGRATION.md)
- [Magic CHANGELOG.md](Magic/CHANGELOG.md)
- [Magic AUTOMATA.md](Magic/AUTOMATA.md)
- [MagicAPI README.md](MagicAPI/README.md)
