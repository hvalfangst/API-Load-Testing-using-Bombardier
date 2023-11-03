package pastor.prayerbook

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication
@EnableWebFlux
class PrayerBookApplication {}

fun main(args: Array<String>) {
    runApplication<PrayerBookApplication>(*args)
}
