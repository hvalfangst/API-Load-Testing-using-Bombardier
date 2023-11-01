package pastor.prayerbook.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pastor.prayerbook.models.PrayerRecord
import pastor.prayerbook.models.requests.UpsertPrayerRequest
import pastor.prayerbook.services.PrayerService

@RestController
@RequestMapping("/prayers")
class PrayerController(private val prayerService: PrayerService) {

    @GetMapping
    fun getAllPrayers(): ResponseEntity<List<PrayerRecord>> {
        val allPrayers = prayerService.getAllPrayers()
        return ResponseEntity.ok(allPrayers)
    }

    @PostMapping
    fun createPrayer(@RequestBody request: UpsertPrayerRequest): ResponseEntity<String> {
        prayerService.createPrayer(request)
        return ResponseEntity.status(HttpStatus.CREATED).body("Prayer created")
    }

}
