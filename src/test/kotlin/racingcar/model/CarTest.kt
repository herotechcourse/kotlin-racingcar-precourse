package racingcar.model

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class CarTest {

    @Test
    fun `Create car with valid name`() {
        val car = Car("pobi")
        assertThat(car.name).isEqualTo("pobi")
    }

    @Test
    fun `car starts at position 0`() {
        val car = Car("pobi")
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `car moves when random is 4 or more`() {
        assertRandomNumberInRangeTest(
            {
                val car = Car("pobi")
                car.move()
                assertThat(car.position).isEqualTo(1)
            },
            4
        )
    }

    @Test
    fun `car doesn't move when random is less than 4`() {
        assertRandomNumberInRangeTest(
            {
                val car = Car("pobi")
                car.move()
                assertThat(car.position).isEqualTo(0)
            },
            3
        )
    }
}