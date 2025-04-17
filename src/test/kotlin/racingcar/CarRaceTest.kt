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


    override fun runMain() {
        racingcar.main()
    }

}