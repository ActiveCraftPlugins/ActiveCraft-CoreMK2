package dev.activecraft.activecraftcore.data.tables

import org.jetbrains.exposed.dao.id.IntIdTable

object EffectsTable : IntIdTable("effects") {

    val profile = uuid("profile") references ProfilesTable.uuid
    val effectType = text("effect_type")
    val active = bool("active")
    @OptIn(ExperimentalUnsignedTypes::class)
    val amplifier = ubyte("amplifier")

}