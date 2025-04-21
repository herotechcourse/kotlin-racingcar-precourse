package racingcar.model

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.main

class CarTest : NsTest() {

    @Test
    fun `test car name`() {
        val carName = "pobi"
        val car = Car(carName)
        assertThat(car.name).isEqualTo(carName)
    }

    @Test
    fun `test car position`() {
        val car = Car("pobi")
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `test car move`() {
        assertRandomNumberInRangeTest(
            {
            val car = Car("pobi")
            car.move()
            assertThat(car.position).isEqualTo(1)
            },
            MOVING_FORWARD
        )
    }

    @Test
    fun `test car multiple move`() {
        assertRandomNumberInRangeTest(
            {
                val car = Car("pobi")
                car.move()
                car.move()
                car.move()
                assertThat(car.position).isEqualTo(2)
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `test car print position`() {
        assertRandomNumberInRangeTest(
            {
                val car = Car("pobi")
                car.move()
                assertThat(car.printPosition()).isEqualTo("pobi : -")
            },
            MOVING_FORWARD
        )

    }
    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}