package com.tupynambalucas.mine.purpur.listeners

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerJoinListener : Listener {

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        val welcomeMessage = Component.text("Bem-vindo ao Amigos Do Mine, ")
            .color(NamedTextColor.GREEN)
            .append(Component.text(player.name).color(NamedTextColor.GOLD))
            .append(Component.text("!").color(NamedTextColor.GREEN))

        player.sendMessage(welcomeMessage)
    }
}
