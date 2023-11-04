package hvalfangst.cars.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.reactive.function.client.WebClient
import hvalfangst.cars.model.PrayerRecord
import hvalfangst.cars.model.UpsertPrayerRequest
import hvalfangst.cars.repository.PrayerRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDate

@RestController
@RequestMapping("/cars")
class PrayerController(
    private val prayerRepository: PrayerRepository,
    private val webClient: WebClient
) {

    @GetMapping
    fun findAll(): Flux<PrayerRecord> {
        return prayerRepository.findAllPrayers()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: UpsertPrayerRequest): Mono<Void> {
        return prayerRepository.createPrayer(
            request.prayerTitle,
            request.prayerText,
            request.prayerIntent,
            request.author,
            LocalDate.now()
        )
    }
}
