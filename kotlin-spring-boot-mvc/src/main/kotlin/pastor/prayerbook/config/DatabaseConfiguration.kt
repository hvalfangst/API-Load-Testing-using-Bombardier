package pastor.prayerbook.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import javax.sql.DataSource

@Component
class DatabaseConfiguration(properties: DatabaseProperties) {
    val log: Logger = LoggerFactory.getLogger(this::class.java)

    init {
       connect(properties)
    }

    /**
     * Establishes a database connection using HikariCP connection pool and runs Flyway migrations.
     */
    fun connect(properties: DatabaseProperties) {
        log.info("Attempting to migrate")
        val pool = createConnectionPool(properties.url)
        Database.connect(pool)
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
}