package com.tupynambalucas.amigosdomine.mechanics.chat

import com.tupynambalucas.amigosdomine.AmigosPlugin
import com.tupynambalucas.amigosdomine.utils.ColorUtils
import io.papermc.paper.event.player.AsyncChatEvent
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class ChatListener(private val plugin: AmigosPlugin) : Listener {

    @EventHandler
    fun onPlayerChat(event: AsyncChatEvent) {
        val player = event.player
        
        // Verifica permissão
        if (!player.hasPermission("amigos.chat.color")) {
            return
        }

        // Converte a mensagem original (Component) para texto puro
        var plainMessage = PlainTextComponentSerializer.plainText().serialize(event.message())

        // Verifica se legacy codes (&a, &1...) estão habilitados na config
        if (plugin.config.getBoolean("mechanics.chat.legacy-colors", true)) {
            plainMessage = ColorUtils.convertLegacyToMiniMessage(plainMessage)
        }

        // Analisa o texto puro (agora com tags convertidas ou originais)
        val coloredMessage = ColorUtils.parse(plainMessage)

        // Substitui a mensagem do evento
        event.message(coloredMessage)
    }
}