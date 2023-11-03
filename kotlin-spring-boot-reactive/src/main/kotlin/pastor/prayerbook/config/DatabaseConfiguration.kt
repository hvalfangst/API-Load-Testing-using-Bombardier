package pastor.prayerbook.config

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration
import io.r2dbc.postgresql.PostgresqlConnectionFactory
import io.r2dbc.spi.ConnectionFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@Configuration
@EnableR2dbcRepositories
class DatabaseConfiguration(
    @Value("\${spring.r2dbc.username}") private val username: String,
    @Value("\${spring.r2dbc.password}") private val password: String,
    @Value("\${spring.r2dbc.port}") private val port: Int,
    @Value("\${spring.r2dbc.database}") private val database: String,
    @Value("\${spring.r2dbc.host}") private val host: String
) : AbstractR2dbcConfiguration() {
    override fun connectionFactory(): ConnectionFactory {
        return PostgresqlConnectionFactory(
            PostgresqlConnectionConfiguration.builder()
                .username(username)
                .password(password)
                .port(port)
                .database(database)
                .host(host)
                .build()
        )
    }
}