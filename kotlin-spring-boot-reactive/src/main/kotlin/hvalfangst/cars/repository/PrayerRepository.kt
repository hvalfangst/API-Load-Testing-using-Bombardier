package hvalfangst.cars.repository

import org.springframework.data.r2dbc.repository.Modifying
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import hvalfangst.cars.model.PrayerRecord
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDate


@Repository
interface PrayerRepository: R2dbcRepository<PrayerRecord, Int> {

    @Query("SELECT * FROM cars")
    fun findAllPrayers(): Flux<PrayerRecord>

    @Modifying
    @Query("INSERT INTO cars (prayer_title, prayer_text, prayer_intent, author, timestamp) " +
            "VALUES (:title, :text, :intent, :author, :timestamp)")
    fun createPrayer(
        @Param("title") title: String,
        @Param("text") text: String,
        @Param("intent") intent: String,
        @Param("author") author: String,
        @Param("timestamp") timestamp: LocalDate
    ): Mono<Void>

}
