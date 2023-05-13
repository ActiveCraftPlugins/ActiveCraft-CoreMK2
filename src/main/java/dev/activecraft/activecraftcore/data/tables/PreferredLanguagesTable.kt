package dev.activecraft.activecraftcore.data.tables

import org.jetbrains.exposed.dao.id.IntIdTable

object PreferredLanguagesTable : IntIdTable("preferred_languages") {

    val profile = uuid("profile") references ProfilesTable.uuid
    val activeCraftMessage = text("activecraft_message")
    val preferredLanguage = varchar("preferred_language", 2)

}