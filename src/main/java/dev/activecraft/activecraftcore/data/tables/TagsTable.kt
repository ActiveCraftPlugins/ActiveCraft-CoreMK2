package dev.activecraft.activecraftcore.data.tables

import org.jetbrains.exposed.dao.id.IntIdTable

object TagsTable : IntIdTable("profile_tags") {

    var profile = uuid("profile") references ProfilesTable.uuid
    var tagValue = text("tag-value")
}