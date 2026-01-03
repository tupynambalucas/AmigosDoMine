package com.tupynambalucas.mine.purpur.features.essentials

import com.tupynambalucas.mine.purpur.AmigosPlugin
import com.tupynambalucas.mine.purpur.features.essentials.spawn.commands.SetSpawnCommand
import com.tupynambalucas.mine.purpur.features.essentials.spawn.commands.SpawnCommand
import com.tupynambalucas.mine.purpur.features.essentials.spawn.SpawnService
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
