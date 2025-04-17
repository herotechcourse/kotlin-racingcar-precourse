package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import camp.nextstep.edu.missionutils.test.NsTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarRaceTest : NsTest() {
    @ParameterizedTest
    @CsvSource(
        value = [
            "car1,car2,car3:3",
            "   pobi  ,    woni   : 5",
            "one, two, three: 1"
        ], delimiter = ':'
    )
    fun initializeRace_testMultipleValidInputs(carNames: String, rounds: String) {
        val input = "$carNames\n$rounds"

        assertSimpleTest {
            run(input)

            val output = output()
            assertThat(output).contains("Race Results")
            carNames.split(",").forEach { name ->
                assertThat(output).contains("${name.trim()} :")
            }
        }
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "car1, car2, car3 car4: 2",
            "car1 car2 car3: 2",
            "car1, car2, toolong: 2",
            "car1, car2, car3: notANumber",
            "car1,car2,car3: 0",
            "car1,car2: -1"
        ], delimiter = ':'
    )
    fun initializeRace_testMultipleInvalidInputs(carNames: String, rounds: String) {
        val input = "$carNames\n$rounds"

        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(input) }
        }
    }

    @Test
    fun selectWinners_returnsWinnersCorrectly() {
        val car1 = Car("car1", 1)
        val car2 = Car("car2", 5)
        val car3 = Car("car3", 3)
        val car4 = Car("car4", 5)

        val cars = listOf(car1, car2, car3, car4)
        val race = CarRace(cars, 1)

        val winners = race.selectWinners()

        assertThat(winners).hasSize(2)
        assertThat(winners).contains("car2", "car4")
        assertThat(winners).doesNotContain("car1", "car3")
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "car1,car2,car3:3",
            "car1,car2,car3:1",
            "car1,car2,car3:50"
        ], delimiter = ':'
    )
    fun startRace_hasCorrectAmountOfRounds(carNames: String, rounds: String) {
        val input = "$carNames\n$rounds"

        assertSimpleTest {
            run(input)

            val output = output()

            val occurrences1 = output.lines().count { it.contains("car1 :") }
            val occurrences2 = output.lines().count { it.contains("car2 :") }
            val occurrences3 = output.lines().count { it.contains("car3 :") }

            assertThat(occurrences1.toString()).isEqualTo(rounds)
            assertThat(occurrences2.toString()).isEqualTo(rounds)
            assertThat(occurrences3.toString()).isEqualTo(rounds)
        }
    }


    override fun runMain() {
        main()
    }

}