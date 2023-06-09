package dev.activecraft.activecraftcore.data.config

import dev.activecraft.activecraftcore.data.config.ActiveCraftConfig
import kotlin.reflect.KProperty

class ConfigValue<T>(
    private val activeCraftConfig: ActiveCraftConfig,
    private val configPath: String,
    private val defaultValue: T
) {

    private var value: T = defaultValue

    @JvmSynthetic
    operator fun getValue(thisRef: Any, property: KProperty<*>): T {
        return getValue()
    }

    @JvmSynthetic
    operator fun setValue(thisRef: Any, property: KProperty<*>, newValue: T) {
        setValue(newValue)
    }

    fun getValue() = value ?: load()

    fun setValue(newValue: T) {
        activeCraftConfig[configPath] = newValue
        value = newValue
    }

    fun load(): T {
        value = runCatching { activeCraftConfig.fileConfig.get(configPath) as T }.getOrElse { defaultValue }
        return value
    }
}