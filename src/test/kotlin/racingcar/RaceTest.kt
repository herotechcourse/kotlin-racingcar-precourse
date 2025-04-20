package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import racingcar.domain.Race
import racingcar.domain.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RaceTest {

    @Test
    @DisplayName("Should move all cars")
    fun `moveAll should move all cars once`() {
        val car1 = Car("pobi")
        val car2 = Car("crong")
        val race = Race(listOf(car1, car2))

        // Simulate a random number >= 4 to move the cars
        assertRandomNumberInRangeTest(
            {
                race.moveAll()
                assertThat(car1.position).isEqualTo(1)
                assertThat(car2.position).isEqualTo(1)
            },
            4
        )
    }

    @Test
    @DisplayName("Should return the winner when one car has the highest position")
    fun `findWinners should return the winner when one car has the highest position`() {
        val car1 = Car("pobi", 2)
        val car2 = Car("crong", 3)
        val race = Race(listOf(car1, car2))

        val winners = race.findWinners()

        assertThat(winners).containsExactly("crong")
    }

    @Test
    @DisplayName("Should return multiple winners if there is a tie")
    fun `findWinners should return multiple winners when there is a tie`() {
        val car1 = Car("pobi", 3)
        val car2 = Car("crong", 3)
        val race = Race(listOf(car1, car2))

        val winners = race.findWinners()

        assertThat(winners).containsExactly("pobi", "crong")
    }

    @Test
    @DisplayName("Should create a race from a list of names")
    fun `fromNames should create a race from a list of names`() {
        val race = Race.fromNames(listOf("pobi", "crong"))

        assertThat(race.cars).hasSize(2)
        assertThat(race.cars[0].name).isEqualTo("pobi")
        assertThat(race.cars[1].name).isEqualTo("crong")
    }


}
