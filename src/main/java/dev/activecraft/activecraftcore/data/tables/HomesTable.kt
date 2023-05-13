package dev.activecraft.activecraftcore.data.tables

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Table

object HomesTable : IntIdTable("homes") {

    var name = varchar("name", 256)
    var owner = uuid("owner") references ProfilesTable.uuid
    var location = varchar("location", 8) references LocationsTable.id

}