package com.amigosdomine.managers

class PluginManager private constructor() {
    companion object {
        private var instance: PluginManager? = null

        fun getInstance(): PluginManager {
            if (instance == null) {
                instance = PluginManager()
            }
            return instance!!
        }
    }

    fun initialize() {
    }
}