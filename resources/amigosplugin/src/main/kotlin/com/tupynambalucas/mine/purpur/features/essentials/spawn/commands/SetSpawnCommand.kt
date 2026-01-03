package com.tupynambalucas.mine.purpur.features.essentials.spawn.commands

import com.tupynambalucas.mine.purpur.features.essentials.spawn.SpawnService
import io.papermc.paper.command.brigadier.BasicCommand
import io.papermc.paper.command.brigadier.CommandSourceStack
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.entity.Player

class SetSpawnCommand(private val spawnService: SpawnService) : BasicCommand {
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

        spawnService.setSpawn(sender.location)
        sender.sendMessage(Component.text("Spawn definido com sucesso!").color(NamedTextColor.GREEN))
    }
}
