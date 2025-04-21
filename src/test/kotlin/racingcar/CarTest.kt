package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {

    @Test
    fun `car name must not be blank or more than 5 characters`() {
        assertThrows<IllegalArgumentException> { Car("") }
        assertThrows<IllegalArgumentException> { Car("toolong") }
    }

    @Test
    fun `car should move forward when random number is 4 or more`() {
        val car = Car("pobi")

        assertRandomNumberInRangeTest(
            {
                car.move()
                assertThat(car.getPosition()).isEqualTo(1)
            },
            4
        )
    }

    @Test
    fun `car should not move when random number is less than 4`() {
        val car = Car("woni")

        assertRandomNumberInRangeTest(
            {
                car.move()
                assertThat(car.getPosition()).isEqualTo(0)
            },
            3
        )
    }

    @Test
    fun `display should return car name followed by position markers`() {
        val car = Car("java")
        assertRandomNumberInRangeTest(
            {
                car.move()
                assertThat(car.display()).isEqualTo("java : -")
            },
            4
        )
    }
}
