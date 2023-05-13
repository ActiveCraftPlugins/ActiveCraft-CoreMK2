package dev.activecraft.activecraftcore.data.tables

import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.javatime.datetime

object ProfilesTable : UUIDTable("profiles") {

    val name = text("name")
    val nickname = text("nickname")
    val prefix = text("prefix")
    val lastOnline = datetime("last_online").nullable()
    val colorNick = text("colornick");
    val timesJoined = integer("times_joined")
    val timesWarned = integer("times_warned")
    val timesMuted = integer("times_muted")
    val timesBanned = integer("times_banned")
    val timesIpBanned = integer("times_ip_banned")
    val playtime = integer("playtime") // in minutes
    val afk = bool("afk")
    val godmode = bool("godmode")
    val fly = bool("fly")
    val muted = bool("muted")
    val defaultmuted = bool("defaultmuted")
    val vanished = bool("vanished")
    val receiveLog = bool("receive_log")
    val bypassLockdown = bool("bypass_lockdown")
    val receiveSocialspy = bool("receive_socialspy")
    val editSign = bool("edit_sign")

}