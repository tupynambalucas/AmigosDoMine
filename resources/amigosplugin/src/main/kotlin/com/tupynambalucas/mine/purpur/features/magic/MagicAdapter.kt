package com.tupynambalucas.mine.purpur.features.magic

import com.elmakers.mine.bukkit.api.magic.MagicAPI
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin

/**
 * Adapter to interface with the Magic Plugin API safely.
 * This class isolates Magic dependencies to avoid runtime errors if the plugin is missing.
 */
class MagicAdapter(private val api: MagicAPI) {

    /**
     * Casts a spell with the given parameters.
     */
    fun castSpell(spellName: String, parameters: Array<String> = emptyArray()): Boolean {
        return api.cast(spellName, parameters)
    }

    /**
     * Spawns a custom Magic mob at the specified location.
     */
    fun spawnMob(mobKey: String, location: Location): Entity? {
        return api.controller.spawnMob(mobKey, location)
    }

    /**
     * Gives a Magic item to a player.
     */
    fun giveItem(player: Player, itemKey: String) {
        val item = api.createItem(itemKey)
        if (item != null) {
            api.giveItemToPlayer(player, item)
        }
    }

    companion object {
        /**
         * Tries to locate the Magic plugin and create an Adapter instance.
         * Returns null if Magic is not installed or incompatible.
         */
        fun tryCreate(): MagicAdapter? {
            val plugin: Plugin? = Bukkit.getPluginManager().getPlugin("Magic")
            if (plugin == null || plugin !is MagicAPI) {
                return null
            }
            return MagicAdapter(plugin)
        }
    }
}
