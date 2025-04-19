package racingcar

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest : NsTest() {
    @Test
    fun `car move test true`() {
        val car = Car("car")
        assertThat(car.position == 0)
        car.move(true)
        assertThat(car.position == 1)
    }

    @Test
    fun `car move test false`() {
        val car = Car("car")
        assertThat(car.position == 0)
        car.move(false)
        assertThat(car.position == 0)
    }

    @Test
    fun `car print result test no round`() {
        val car = Car("car")
        car.toString()
        assertThat(output().contains("car : "))
    }

    @Test
    fun `car print result test one round`() {
        val car = Car("car")
        car.move(true)
        car.toString()
        assertThat(output().contains("car : -"))
    }

    @Test
    fun `car print result test two round`() {
        val car = Car("car")
        repeat(2) {
            car.move(true)
        }
        car.toString()
        assertThat(output().contains("car : --"))
    }

    override fun runMain() {
        main()
    }
}