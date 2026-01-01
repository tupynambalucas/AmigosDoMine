package com.amigosdomine.utils

import net.md_5.bungee.api.ChatColor
import java.util.regex.Pattern

object Utils {
    fun colorize(msg: String): String {
        var message = msg
        val pattern = Pattern.compile("#[a-fA-F0-9]{6}")
        var matcher = pattern.matcher(message)
        while (matcher.find()) {
            val color = message.substring(matcher.start(), matcher.end())
            message = message.replace(color, ChatColor.of(color).toString())
            matcher = pattern.matcher(message)
        }
        return ChatColor.translateAlternateColorCodes('&', message)
    }
}