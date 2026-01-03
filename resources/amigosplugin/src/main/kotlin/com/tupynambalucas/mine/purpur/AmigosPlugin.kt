package com.tupynambalucas.mine.purpur

import com.tupynambalucas.mine.purpur.commands.AmigosCommand
import com.tupynambalucas.mine.purpur.features.essentials.EssentialsFeature
import com.tupynambalucas.mine.purpur.features.magic.MagicAdapter
import com.tupynambalucas.mine.purpur.listeners.PlayerJoinListener
import com.tupynambalucas.mine.purpur.mechanics.chat.ChatListener
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.plugin.java.JavaPlugin

class AmigosPlugin : JavaPlugin() {

    var magicAdapter: MagicAdapter? = null
        private set

    override fun onEnable() {
        // Save default config if not exists
        saveDefaultConfig()

        // Initialize MagicAdapter
        magicAdapter = MagicAdapter.tryCreate()
        if (magicAdapter != null) {
            componentLogger.info(Component.text("MagicAPI hooked successfully!").color(NamedTextColor.AQUA))
        } else {
            componentLogger.info(Component.text("MagicAPI not found. Magic features disabled.").color(NamedTextColor.YELLOW))
        }

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
