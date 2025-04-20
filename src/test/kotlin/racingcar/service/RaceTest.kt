package racingcar.service

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RaceTest {

    @Test
    fun `createRaceSession should create a race with correct car names and rounds`(){
        val carNames = listOf("pobi", "woni", "jun")
        val numberOfRounds = 5

        val race = Race.createRaceSession(carNames, numberOfRounds)

        carNames.forEachIndexed { idx, carName ->
            assertThat(carName).isEqualTo(race.cars[idx].name)
        }
        assertThat(numberOfRounds).isEqualTo(race.numberOfRounds)
    }

    @ParameterizedTest
    @CsvSource(
        "4,1,3",
        "5,5,5",
        "3,2,1"
    )
    fun `car movement should depend on threshold condition`(firstCarNumber: Int, secondCarNumber: Int, thirdCarNumber: Int) {
        val moveThreshold = 4
        val carsRandomNumbers = listOf(firstCarNumber, secondCarNumber, thirdCarNumber)
        val carNames = listOf("pobi", "woni", "jun")
        val numberOfRounds = 1
        val race = Race.createRaceSession(carNames, numberOfRounds)

        race.cars.forEachIndexed { idx, car ->
            if (carsRandomNumbers[idx] >= moveThreshold) {
                car.moveForward()
            }
        }

        race.cars.forEachIndexed { idx, car ->
            val expectedPositon: Int = if (carsRandomNumbers[idx] >= moveThreshold) 1 else 0
            assertThat(car.position).isEqualTo(expectedPositon)
        }
    }

    @ParameterizedTest
    @CsvSource(
        "4,3,2,'pobi'",
        "2,4,5,'woni, jun'",
        "2,2,5,'jun'"
    )
    fun `race should select car with lead position as a winner`(firstCarNumber: Int, secondCarNumber: Int, thirdCarNumber: Int, winners: String) {
        val moveThreshold = 4
        val carsRandomNumbers = listOf(firstCarNumber, secondCarNumber, thirdCarNumber)
        val carNames = listOf("pobi", "woni", "jun")
        val numberOfRounds = 1
        val race = Race.createRaceSession(carNames, numberOfRounds)

        race.cars.forEachIndexed { idx, car ->
            if (carsRandomNumbers[idx] >= moveThreshold) {
                car.moveForward()
            }
        }

        val leadingPosition = race.cars.maxOf { car -> car.position }
        val leadingCars = race.cars.filter { car -> car.position == leadingPosition }.map { car -> car.name }.joinToString(", ")
        assertThat(leadingCars).isEqualTo(winners)
    }
}