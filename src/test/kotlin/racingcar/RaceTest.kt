package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest : NsTest() {

    @Test
    fun `print round data`() {
        val carData = mapOf("car1" to 1, "car2" to 2, "car3" to 0, "car4" to 4)
        printRound(carData)
        assertThat(output()).contains("car1 : -", "car2 : --", "car3 : ", "car4 : ----")
    }

    override fun runMain() {
        main()
    }
}