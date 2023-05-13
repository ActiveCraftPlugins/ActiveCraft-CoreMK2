package dev.activecraft.activecraftcore.data.tables

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.datetime

object WarnsTable : IntIdTable("warns") {

    val profile = uuid("profile") references ProfilesTable.uuid
    val reason = text("reason")
    val created = datetime("created")
    val warnSource = text("source")

}