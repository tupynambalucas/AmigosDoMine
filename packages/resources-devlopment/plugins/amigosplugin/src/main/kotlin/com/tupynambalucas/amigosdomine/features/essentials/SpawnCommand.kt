package com.tupynambalucas.amigosdomine.features.essentials

import com.tupynambalucas.amigosdomine.AmigosPlugin
import io.papermc.paper.command.brigadier.BasicCommand
import io.papermc.paper.command.brigadier.CommandSourceStack
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.Player

class SpawnCommand(private val plugin: AmigosPlugin) : BasicCommand {
    override fun execute(stack: CommandSourceStack, args: Array<out String>) {
        val sender = stack.sender
        if (sender !is Player) {
            sender.sendMessage(Component.text("Apenas jogadores podem usar este comando.").color(NamedTextColor.RED))
            return
        }

        if (!sender.hasPermission("amigos.spawn")) {
            sender.sendMessage(Component.text("Você não tem permissão para usar /spawn.").color(NamedTextColor.RED))
            return
        }

        val config = plugin.config
        val worldName = config.getString("spawn.world")
        if (worldName == null) {
            sender.sendMessage(Component.text("Spawn ainda não foi definido.").color(NamedTextColor.RED))
            return
        }

        val world = Bukkit.getWorld(worldName)
        if (world == null) {
            sender.sendMessage(Component.text("Mundo do spawn não encontrado.").color(NamedTextColor.RED))
            return
        }

        val x = config.getDouble("spawn.x")
        val y = config.getDouble("spawn.y")
        val z = config.getDouble("spawn.z")
        val yaw = config.getDouble("spawn.yaw").toFloat()
        val pitch = config.getDouble("spawn.pitch").toFloat()

        val location = Location(world, x, y, z, yaw, pitch)
        sender.teleport(location)
        sender.sendMessage(Component.text("Teleportado para o spawn!").color(NamedTextColor.GREEN))
    }
}
