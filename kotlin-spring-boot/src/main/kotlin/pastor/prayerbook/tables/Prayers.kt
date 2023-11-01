package pastor.prayerbook.tables

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.date

object Prayers : Table("prayers") {
    val id = integer("id").autoIncrement()
    val prayerTitle = text("prayer_title")
    val prayerText = text("prayer_text")
    val prayerIntent = text("prayer_intent")
    val author = varchar("author", length = 12)
    val timestamp = date("timestamp")
}
