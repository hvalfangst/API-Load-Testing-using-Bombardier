package hvalfangst.cars.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable
import java.time.LocalDate

data class PrayerRecord(
    @JsonProperty("id")
    val id: Int,

    @JsonProperty("prayerTitle")
    val prayerTitle: String,

    @JsonProperty("prayerText")
    val prayerText: String,

    @JsonProperty("prayerIntent")
    val prayerIntent: String,

    @JsonProperty("author")
    val author: String,

    @JsonProperty("timestamp")
    val timestamp: LocalDate
) : Serializable
