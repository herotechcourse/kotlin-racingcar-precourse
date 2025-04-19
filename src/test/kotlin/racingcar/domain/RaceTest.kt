package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class RaceTest {

    @Nested
    @DisplayName("Race initialization")
    inner class RaceInitialization {

        @Test
        @DisplayName("should initialize race with correct number of rounds and cars")
        fun initializeRace() {
            val car1 = Car("car1")
            val car2 = Car("car2")
            val cars = listOf(car1, car2)
            val rounds = 3

            val race = Race(cars, rounds)
            assertThat(race.raceHistory).hasSize(rounds)
            assertThat(race.raceHistory[0]).hasSize(cars.size)
        }
    }

    @Nested
    @DisplayName("Race behavior tests")
    inner class RaceStructure {

        @Test
        @DisplayName("should store car names in race history")
        fun storeCarNamesInHistory() {
            val car1 = Car("first-car")
            val car2 = Car("second-car")
            val cars = listOf(car1, car2)
            val race = Race(cars, 1)

            race.simulate()

            assertThat(race.raceHistory[0][0].first).isEqualTo("first-car")
            assertThat(race.raceHistory[0][1].first).isEqualTo("second-car")
        }

        @Test
        @DisplayName("should update race history with car progression")
        fun updateRaceHistoryWithCarProgression() {
            val car1 = Car("car1")
            val car2 = Car("car2")
            val cars = listOf(car1, car2)
            val race = Race(cars, 1)

            race.simulate()

            assertThat(race.raceHistory[0][0].second).isEqualTo(car1.progression)
            assertThat(race.raceHistory[0][1].second).isEqualTo(car2.progression)
        }
    }

    @Nested
    @DisplayName("Determining winners")
    inner class DeterminingWinners {

        @Test
        @DisplayName("should return empty list if no cars")
        fun noCars() {
            val race = Race(emptyList(), 3)
            race.simulate()

            val winners = race.getWinners()
            assertThat(winners).isEmpty()
        }

        @Test
        @DisplayName("should identify winner with highest progression")
        fun identifyWinnerWithHighestProgression() {
            val car1 = Car("car1")
            val car2 = Car("car2")
            val car3 = Car("car3")
            val cars = listOf(car1, car2, car3)
            val race = Race(cars, 1)

            // WARNING: Only for Test purpose
            // Use reflection to access and manipulate _raceHistory directly
            val raceHistoryField = Race::class.java.getDeclaredField("_raceHistory")
            raceHistoryField.isAccessible = true
            @Suppress("UNCHECKED_CAST")
            val raceHistory = raceHistoryField.get(race) as List<MutableList<Pair<String, Int>>>

            raceHistory[0].clear()
            raceHistory[0].add("car1" to 5)
            raceHistory[0].add("car2" to 3)
            raceHistory[0].add("car3" to 4)

            val winners = race.getWinners()
            assertThat(winners).containsExactly("car1")
        }

        @Test
        @DisplayName("should identify multiple winners with same progression")
        fun identifyMultipleWinnersWithSameProgression() {
            val car1 = Car("car1")
            val car2 = Car("car2")
            val car3 = Car("car3")
            val cars = listOf(car1, car2, car3)
            val race = Race(cars, 1)

            // WARNING: Only for Test purpose
            // Use reflection to access and manipulate _raceHistory directly
            val raceHistoryField = Race::class.java.getDeclaredField("_raceHistory")
            raceHistoryField.isAccessible = true
            @Suppress("UNCHECKED_CAST")
            val raceHistory = raceHistoryField.get(race) as List<MutableList<Pair<String, Int>>>

            raceHistory[0].clear()
            raceHistory[0].add("car1" to 5)
            raceHistory[0].add("car2" to 5)
            raceHistory[0].add("car3" to 3)

            val winners = race.getWinners()
            assertThat(winners).containsExactlyInAnyOrder("car1", "car2")
        }

        @Test
        @DisplayName("should identify all cars as winners when all have zero progression")
        fun allCarsWithZeroProgression() {
            val car1 = Car("car1")
            val car2 = Car("car2")
            val car3 = Car("car3")
            val cars = listOf(car1, car2, car3)
            val race = Race(cars, 1)

            // WARNING: Only for Test purpose
            // Use reflection to access and manipulate _raceHistory directly
            val raceHistoryField = Race::class.java.getDeclaredField("_raceHistory")
            raceHistoryField.isAccessible = true
            @Suppress("UNCHECKED_CAST")
            val raceHistory = raceHistoryField.get(race) as List<MutableList<Pair<String, Int>>>

            raceHistory[0].clear()
            raceHistory[0].add("car1" to 0)
            raceHistory[0].add("car2" to 0)
            raceHistory[0].add("car3" to 0)

            val winners = race.getWinners()
            assertThat(winners).containsExactlyInAnyOrder("car1", "car2", "car3")
        }
    }
}
