package com.amigosdomine

import org.bukkit.plugin.java.JavaPlugin
import com.amigosdomine.listeners.PlayerListener
import com.amigosdomine.managers.PluginManager

class AmigosPlugin : JavaPlugin() {
    override fun onEnable() {
        PluginManager.getInstance().initialize()
        server.pluginManager.registerEvents(PlayerListener(), this)
        logger.info("AmigosPlugin ativado com sucesso!")
    }

    override fun onDisable() {
        logger.info("AmigosPlugin desativado!")
    }
}