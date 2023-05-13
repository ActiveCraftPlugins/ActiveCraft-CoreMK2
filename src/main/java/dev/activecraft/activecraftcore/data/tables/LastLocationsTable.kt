package dev.activecraft.activecraftcore.data.tables

import org.jetbrains.exposed.dao.id.IntIdTable

object LastLocationsTable : IntIdTable("last_locations") {

    val profile = uuid("profile") references ProfilesTable.uuid
    val worldname = text("world")
    val location = varchar("location", 8) references LocationsTable.id
    val lastBeforeQuit = bool("last_before_quit")

}