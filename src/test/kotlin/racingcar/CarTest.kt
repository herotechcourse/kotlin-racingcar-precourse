package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.generator.FixedRandomNumberGenerator

class CarTest {

    @Nested
    @DisplayName("Name Validation Tests")
    inner class NameValidationTest {

        @ParameterizedTest(name = "{0}")
        @ValueSource(strings = ["a", "ab", "abc", "abcd"])
        fun `Car name should be valid if it is 5 characters or less`(name: String) {
            val car = Car(name)

            assertEquals(car.name, name)
            assertEquals(car.position, 0)
        }

        @ParameterizedTest(name = "{0}")
        @ValueSource(strings = ["abcdef", "123456", "too long name"])
        fun `Car should throw an exception if the name is 6 characters or longer`(name: String) {
            assertThrows<IllegalArgumentException> {
                Car(name)
            }
        }

    }

    @Nested
    @DisplayName("Move Condition Tests")
    inner class MoveConditionTest {

        private lateinit var car: Car

        @BeforeEach
        fun init() {
            car = Car("pobi")
        }

        @ParameterizedTest(name = "{0}")
        @ValueSource(ints = [1, 2, 3])
        fun `Car should not move if fixedValue is less than 4`(fixedValue: Int) {
            val fixedRandomNumberGenerator = FixedRandomNumberGenerator(fixedValue)

            car.move(fixedRandomNumberGenerator)

            assertEquals(car.position, 0)
        }

        @ParameterizedTest(name = "{0}")
        @ValueSource(ints = [4, 5, 6, 7, 8, 9])
        fun `Car should move if fixedValue is greater than or equal to 4`(fixedValue: Int) {
            val fixedRandomNumberGenerator = FixedRandomNumberGenerator(fixedValue)

            car.move(fixedRandomNumberGenerator)

            assertEquals(car.position, 1)
        }

    }

}