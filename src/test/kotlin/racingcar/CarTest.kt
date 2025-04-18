package racingcar

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest : NsTest() {
    @Test
    fun `car move test`() {
        val car = Car("car")
        car.move(true)
        assertThat(car.position == 1)
    }

    @Test
    fun `car print result test`() {
        val car = Car("car")
        car.move(true)
        car.toString()
        assertThat(output().contains("car : -"))
    }

    override fun runMain() {
        main()
    }
}