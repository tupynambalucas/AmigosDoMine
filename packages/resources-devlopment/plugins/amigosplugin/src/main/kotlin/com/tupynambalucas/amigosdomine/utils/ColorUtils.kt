package com.tupynambalucas.amigosdomine.utils

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage

object ColorUtils {
    private val miniMessage = MiniMessage.miniMessage()

    fun parse(message: String): Component {
        return miniMessage.deserialize(message)
    }
}
