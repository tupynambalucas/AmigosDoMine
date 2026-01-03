package com.tupynambalucas.amigosdomine.commands

import io.papermc.paper.command.brigadier.BasicCommand
import io.papermc.paper.command.brigadier.CommandSourceStack
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor

class AmigosCommand : BasicCommand {
    override fun execute(stack: CommandSourceStack, args: Array<out String>) {
        stack.sender.sendMessage(
            Component.text("Comando Amigos executado com sucesso!")
                .color(NamedTextColor.AQUA)
        )
    }
}
