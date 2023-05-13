package dev.activecraft.activecraftcore.data.tables

import org.jetbrains.exposed.dao.id.IntIdTable

object PrefixesTable : IntIdTable("prefixes") {

    val profile = uuid("profile") references ProfilesTable.uuid
    val prefix = text("prefix")

}