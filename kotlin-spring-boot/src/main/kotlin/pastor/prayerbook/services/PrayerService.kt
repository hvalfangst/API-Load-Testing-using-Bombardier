package pastor.prayerbook.services

import org.springframework.stereotype.Service
import pastor.prayerbook.models.PrayerRecord
import pastor.prayerbook.models.requests.UpsertPrayerRequest
import pastor.prayerbook.repositories.PrayerRepository

@Service
class PrayerService(private val prayerRepository: PrayerRepository) {

    fun getAllPrayers(): List<PrayerRecord> {
        return prayerRepository.getAllPrayers()
    }

    fun createPrayer(request: UpsertPrayerRequest) {
        return prayerRepository.createPrayer(request)
    }

}
