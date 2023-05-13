package dev.activecraft.activecraftcore.domain.manger

import dev.activecraft.activecraftcore.data.dao.Profile
import org.bukkit.entity.Player
import org.jetbrains.exposed.sql.transactions.transaction

object ProfileManager {

    val profiles: List<Profile>
        get() = transaction { Profile.all().toList() }

    fun createProfile(player: Player): Unit = transaction {
        Profile.new {
            name
        }
    }

}