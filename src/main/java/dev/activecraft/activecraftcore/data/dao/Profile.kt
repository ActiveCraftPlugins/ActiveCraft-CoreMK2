package dev.activecraft.activecraftcore.data.dao

import dev.activecraft.activecraftcore.data.tables.ProfilesTable
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.*

class Profile(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object : UUIDEntityClass<Profile>(ProfilesTable)

    val name by ProfilesTable.name
    val nickname by ProfilesTable.nickname
    val prefix by ProfilesTable.prefix
    val lastOnline by ProfilesTable.lastOnline
    val colorNick by ProfilesTable.colorNick
    val timesJoined by ProfilesTable.timesJoined
    val timesWarned by ProfilesTable.timesWarned
    val timesMuted by ProfilesTable.timesMuted
    val timesBanned by ProfilesTable.timesBanned
    val timesIpBanned by ProfilesTable.timesIpBanned
    val playtime by ProfilesTable.playtime
    val afk by ProfilesTable.afk
    val godmode by ProfilesTable.godmode
    val fly by ProfilesTable.fly
    val muted by ProfilesTable.muted
    val defaultmuted by ProfilesTable.defaultmuted
    val vanished by ProfilesTable.vanished
    val receiveLog by ProfilesTable.receiveLog
    val bypassLockdown by ProfilesTable.bypassLockdown
    val receiveSocialspy by ProfilesTable.receiveSocialspy
    val editSign by ProfilesTable.editSign

}