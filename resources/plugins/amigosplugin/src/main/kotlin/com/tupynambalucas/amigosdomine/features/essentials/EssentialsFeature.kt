package com.tupynambalucas.amigosdomine.features.essentials

import com.tupynambalucas.amigosdomine.AmigosPlugin
import com.tupynambalucas.amigosdomine.features.essentials.spawn.commands.SetSpawnCommand
import com.tupynambalucas.amigosdomine.features.essentials.spawn.commands.SpawnCommand
import com.tupynambalucas.amigosdomine.features.essentials.spawn.SpawnService
import io.papermc.paper.command.brigadier.Commands

object EssentialsFeature {
    fun registerCommands(plugin: AmigosPlugin, commands: Commands) {
        // Dependency Injection
        val spawnService = SpawnService(plugin)

        // Register Commands with dependencies injected
        commands.register("setspawn", SetSpawnCommand(spawnService))
        commands.register("spawn", SpawnCommand(spawnService))
    }
}
