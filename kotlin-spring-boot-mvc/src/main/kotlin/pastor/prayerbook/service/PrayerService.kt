package pastor.prayerbook.service

import org.springframework.stereotype.Service
import pastor.prayerbook.model.PrayerRecord
import pastor.prayerbook.model.UpsertPrayerRequest
import pastor.prayerbook.repository.PrayerRepository

@Service
class PrayerService(private val prayerRepository: PrayerRepository) {

    fun getAllPrayers(): List<PrayerRecord> {
        return prayerRepository.getAllPrayers()
    }

    fun createPrayer(request: UpsertPrayerRequest) {
        return prayerRepository.createPrayer(request)
    }

}
