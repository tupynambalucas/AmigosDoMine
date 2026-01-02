package com.tupynambalucas.amigosdomine

import com.tupynambalucas.amigosdomine.commands.AmigosCommand
import com.tupynambalucas.amigosdomine.listeners.PlayerJoinListener
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.plugin.java.JavaPlugin

class AmigosPlugin : JavaPlugin() {

    override fun onEnable() {
        // Register Listeners
        server.pluginManager.registerEvents(PlayerJoinListener(), this)

        // Register Commands
        getCommand("amigos")?.setExecutor(AmigosCommand())

        // Using Paper/Purpur Component API for logging
        componentLogger.info(
            Component.text("AmigosPlugin has been enabled!")
                .color(NamedTextColor.GREEN)
        )
    }

    override fun onDisable() {
        componentLogger.info(
            Component.text("AmigosPlugin has been disabled!")
                .color(NamedTextColor.RED)
        )
    }
}
