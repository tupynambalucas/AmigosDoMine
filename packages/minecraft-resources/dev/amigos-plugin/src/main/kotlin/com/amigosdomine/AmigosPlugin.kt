package com.amigosdomine

import org.bukkit.plugin.java.JavaPlugin

class AmigosMestre : JavaPlugin() {
    override fun onEnable() {
        logger.info("AmigosMestre ativado!")
    }

    override fun onDisable() {
        logger.info("AmigosMestre desativado!")
    }
}