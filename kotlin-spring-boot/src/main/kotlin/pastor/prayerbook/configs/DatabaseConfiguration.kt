package pastor.prayerbook.configs

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import javax.sql.DataSource

@Component
class DatabaseConfiguration(properties: DatabaseProperties) {
    val log: Logger = LoggerFactory.getLogger(this::class.java)

    init {
       connectAndMigrate(properties)
    }

    /**
     * Establishes a database connection using HikariCP connection pool and runs Flyway migrations.
     */
    fun connectAndMigrate(properties: DatabaseProperties) {
        log.info("Attempting to migrate")
        val pool = createConnectionPool(properties.url)
        Database.connect(pool)
        runFlyway(properties.migrationPath, pool)
    }

    /**
     * Creates and configures a HikariCP connection pool based on application configuration.
     *
     * @return HikariCP data source.
     */
    private fun createConnectionPool(url: String): HikariDataSource {
        val config = HikariConfig().apply {
            driverClassName = "org.postgresql.Driver"
            this.jdbcUrl = url
            maximumPoolSize = 3
            isAutoCommit = false
            transactionIsolation = "TRANSACTION_REPEATABLE_READ"
            validate()
        }
        return HikariDataSource(config)
    }

    /**
     * Runs database migrations using Flyway based on the specified migration locations.
     *
     * @param datasource The data source for the database.
     */
    private fun runFlyway(migrationPath: String, datasource: DataSource) {
        log.info("Attempting to run flyway")
        val flyway = Flyway.configure()
            .dataSource(datasource)
            .locations(migrationPath)
            .load()
        try {
            flyway.info()
            flyway.migrate()
        } catch (e: Exception) {
            log.error("Exception running Flyway migration", e)
            throw e
        }
        log.info("Flyway migration has finished")
    }
}