package racingcar.unit

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.Car

class CarTest {
    @Nested
    @DisplayName("constructor")
    inner class ConstructorTest {
        @Test
        fun `should create a car with a valid name`() {
            val car = Car("pobi")
            assertThat(car.name).isEqualTo("pobi")
            assertThat(car.position).isEqualTo(0)
        }

        @Test
        fun `should throw exception if car name is empty`() {
            val exception = assertThrows<IllegalArgumentException> {
                Car("")
            }
            assertThat(exception.message).isEqualTo("Car name cannot be empty.")
        }

        @Test
        fun `should throw exception if car name contain space`() {
            val exception = assertThrows<IllegalArgumentException> {
                Car("po bi")
            }
            assertThat(exception.message).isEqualTo("Car name cannot contain spaces.")
        }

        @Test
        fun `should throw exception if car name exceeds 5 characters`() {
            val exception = assertThrows<IllegalArgumentException> {
                Car("foobar")
            }
            assertThat(exception.message).isEqualTo("Car name cannot exceed 5 characters.")
        }
    }

    @Nested
    @DisplayName("moveRandomly()")
    inner class MoveRandomlyTest {
        @Test
        fun `should move forward if random number greater than or equal to 4`() {
            val car = Car("pobi")

            assertRandomNumberInRangeTest(
                {
                    car.moveRandomly()
                    assertThat(car.position).isEqualTo(1)
                },
                4
            )
        }

        @Test
        fun `should not move if random number less than 4`() {
            val car = Car("pobi")

            assertRandomNumberInRangeTest(
                {
                    car.moveRandomly()
                    assertThat(car.position).isEqualTo(0)
                },
                3
            )
        }
    }
}