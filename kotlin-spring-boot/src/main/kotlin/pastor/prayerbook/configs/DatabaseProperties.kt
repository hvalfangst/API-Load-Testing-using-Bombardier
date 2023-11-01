package pastor.prayerbook.configs

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * Configuration class for holding properties related to the source and prayer databases.
 * The prefix "env" is used to locate the properties in the application properties file.
 */
@Component
@ConfigurationProperties(prefix = "env")
class DatabaseProperties {
        var url: String = "NIL"
        var migrationPath: String = "NIL"
}