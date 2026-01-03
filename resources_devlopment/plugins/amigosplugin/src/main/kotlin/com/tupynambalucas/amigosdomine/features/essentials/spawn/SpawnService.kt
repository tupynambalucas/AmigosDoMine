package com.tupynambalucas.amigosdomine.features.essentials.spawn

import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.plugin.java.JavaPlugin

class SpawnService(private val plugin: JavaPlugin) {

    fun getSpawn(): Location? {
        val config = plugin.config
        val worldName = config.getString("spawn.world") ?: return null
        val world = Bukkit.getWorld(worldName) ?: return null
        
        val x = config.getDouble("spawn.x")
        val y = config.getDouble("spawn.y")
        val z = config.getDouble("spawn.z")
        val yaw = config.getDouble("spawn.yaw").toFloat()
        val pitch = config.getDouble("spawn.pitch").toFloat()

        return Location(world, x, y, z, yaw, pitch)
    }

    fun setSpawn(location: Location) {
        val config = plugin.config
        config.set("spawn.world", location.world.name)
        config.set("spawn.x", location.x)
        config.set("spawn.y", location.y)
        config.set("spawn.z", location.z)
        config.set("spawn.yaw", location.yaw)
        config.set("spawn.pitch", location.pitch)
        plugin.saveConfig()
    }
}
