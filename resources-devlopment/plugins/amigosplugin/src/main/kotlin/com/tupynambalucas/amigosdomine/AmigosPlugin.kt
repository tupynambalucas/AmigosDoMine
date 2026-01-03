package com.tupynambalucas.amigosdomine

import com.tupynambalucas.amigosdomine.commands.AmigosCommand
import com.tupynambalucas.amigosdomine.features.essentials.EssentialsFeature
import com.tupynambalucas.amigosdomine.listeners.PlayerJoinListener
import com.tupynambalucas.amigosdomine.mechanics.chat.ChatListener
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.plugin.java.JavaPlugin

class AmigosPlugin : JavaPlugin() {

    override fun onEnable() {
        // Save default config if not exists
        saveDefaultConfig()

        // Register Listeners
        server.pluginManager.registerEvents(PlayerJoinListener(), this)
        server.pluginManager.registerEvents(ChatListener(this), this)

        // Register Commands via LifecycleManager (Paper 1.21+)
        val manager = this.lifecycleManager
        manager.registerEventHandler(LifecycleEvents.COMMANDS) { event ->
            val commands = event.registrar()
            commands.register("amigos", AmigosCommand())
            
            // Register Features
            EssentialsFeature.registerCommands(this, commands)
        }

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
