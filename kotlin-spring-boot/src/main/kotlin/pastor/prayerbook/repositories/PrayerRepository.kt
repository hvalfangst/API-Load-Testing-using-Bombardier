package pastor.prayerbook.repositories

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import pastor.prayerbook.models.PrayerRecord
import pastor.prayerbook.models.requests.UpsertPrayerRequest
import pastor.prayerbook.tables.Prayers
import java.time.LocalDate


@Repository
class PrayerRepository() {

    fun getAllPrayers(): List<PrayerRecord> {
        return transaction {
            Prayers.selectAll().map { it.toPrayerRecord() }
        }
    }

    fun createPrayer(request: UpsertPrayerRequest) {
        val currentTimestamp = LocalDate.now()

        transaction {
            Prayers.insert {
                it[prayerTitle] = request.prayerTitle
                it[prayerText] = request.prayerText
                it[prayerIntent] = request.prayerIntent
                it[author] = request.author
                it[timestamp] = currentTimestamp
            }
        }
    }

    private fun ResultRow.toPrayerRecord(): PrayerRecord {
        return PrayerRecord(
            id = this[Prayers.id],
            prayerTitle = this[Prayers.prayerTitle],
            prayerText = this[Prayers.prayerText],
            prayerIntent = this[Prayers.prayerIntent],
            author = this[Prayers.author],
            timestamp = this[Prayers.timestamp]
        )
    }
}
