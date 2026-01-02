package com.tupynambalucas.amigosdomine.commands

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class AmigosCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        sender.sendMessage(
            Component.text("Comando Amigos executado com sucesso!")
                .color(NamedTextColor.AQUA)
        )
        return true
    }
}
