package com.tupynambalucas.amigosdomine.features.essentials

import com.tupynambalucas.amigosdomine.AmigosPlugin
import io.papermc.paper.command.brigadier.BasicCommand
import io.papermc.paper.command.brigadier.CommandSourceStack
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.entity.Player

class SetSpawnCommand(private val plugin: AmigosPlugin) : BasicCommand {
    override fun execute(stack: CommandSourceStack, args: Array<out String>) {
        val sender = stack.sender
        if (sender !is Player) {
            sender.sendMessage(Component.text("Apenas jogadores podem usar este comando.").color(NamedTextColor.RED))
            return
        }

        if (!sender.hasPermission("amigos.admin.setspawn")) {
            sender.sendMessage(Component.text("Você não tem permissão para isso.").color(NamedTextColor.RED))
            return
        }

        val location = sender.location
        val config = plugin.config
        config.set("spawn.world", location.world.name)
        config.set("spawn.x", location.x)
        config.set("spawn.y", location.y)
        config.set("spawn.z", location.z)
        config.set("spawn.yaw", location.yaw)
        config.set("spawn.pitch", location.pitch)
        plugin.saveConfig()

        sender.sendMessage(Component.text("Spawn definido com sucesso!").color(NamedTextColor.GREEN))
    }
}
