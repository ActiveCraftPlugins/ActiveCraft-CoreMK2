package dev.activecraft.activecraftcore

import org.bukkit.plugin.java.JavaPlugin
import java.time.format.DateTimeFormatter

val dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")

class ActiveCraftCore : JavaPlugin() {

    companion object {
        lateinit var INSTANCE: ActiveCraftCore
    }

    init {
        INSTANCE = this
    }

    override fun onPluginEnabled() {

    }

    override fun onPluginDisabled() {

    }

}