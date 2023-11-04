package hvalfangst.cars.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class UpsertPrayerRequest(
    @JsonProperty("prayerTitle")
    val prayerTitle: String,

    @JsonProperty("prayerText")
    val prayerText: String,

    @JsonProperty("prayerIntent")
    val prayerIntent: String,

    @JsonProperty("author")
    val author: String,
) : Serializable