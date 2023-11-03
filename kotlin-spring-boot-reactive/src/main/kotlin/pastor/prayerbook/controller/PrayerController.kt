package pastor.prayerbook.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pastor.prayerbook.model.PrayerRecord
import pastor.prayerbook.model.UpsertPrayerRequest
import pastor.prayerbook.repository.PrayerRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDate

@RestController
@RequestMapping("/prayers")
class PrayerController(
    private val prayerRepository: PrayerRepository
) {

    @GetMapping()
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
