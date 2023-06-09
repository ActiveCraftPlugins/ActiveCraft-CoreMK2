package dev.activecraft.activecraftcore.data

import dev.activecraft.activecraftcore.ActiveCraftCore
import dev.activecraft.activecraftcore.data.tables.*
import dev.activecraft.activecraftcore.exceptions.StartupException
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

class SQLManager {


    lateinit var database: Database

    fun init() {
        val mainConfig = ActiveCraftCore.INSTANCE.mainConfig
        val dialect: DatabaseDialect
        try {
            dialect = DatabaseDialect.valueOf(mainConfig.databaseDialect!!.uppercase())
        } catch (e: IllegalArgumentException) {
            throw StartupException(true, "Invalid database dialect. Check your \"config.yml\"")
        } catch (e: NullPointerException) {
            throw StartupException(true, "Invalid database dialect. Check your \"config.yml\"")
        }

        try {
            database = when (dialect) {
                DatabaseDialect.SQLITE -> Database.connect(
                    url = "jdbc:sqlite:${ActiveCraftCore.INSTANCE.dataFolder}/${mainConfig.databaseLocalPath}",
                    driver = "org.sqlite.JDBC"
                )

                DatabaseDialect.MYSQL -> Database.connect(
                    url = "jdbc:mysql://${mainConfig.databaseHost}:${mainConfig.databasePort}/${mainConfig.databaseNetworkPath}",
                    driver = "com.mysql.cj.jdbc.Driver",
                    user = mainConfig.databaseUser!!,
                    password = mainConfig.databasePassword!!
                )
            }
        } catch (e: Exception) {
            throw StartupException(true, e.message)
        }

        transaction {
            try {
                SchemaUtils.create(
                    EffectsTable,
                    HomesTable,
                    LastLocationsTable,
                    LocationsTable,
                    PreferredLanguagesTable,
                    PrefixesTable,
                    ProfilesTable,
                    TagsTable,
                    WarnsTable
                )
            } catch (e: Exception) {
                throw StartupException(true, e.message)
            }
        }
    }

}