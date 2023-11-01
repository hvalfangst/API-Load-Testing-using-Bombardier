package pastor.prayerbook.db.migration

import org.flywaydb.core.api.migration.BaseJavaMigration
import org.flywaydb.core.api.migration.Context
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import pastor.prayerbook.tables.Prayers

class V1__create_prayers_table : BaseJavaMigration() {
    override fun migrate(context: Context?) {
        transaction {
            createPrayersTable()
        }
    }

    private fun createPrayersTable() {
        SchemaUtils.create(Prayers)
    }
}