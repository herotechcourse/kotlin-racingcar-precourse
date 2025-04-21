package racingcar.domain

import org.junit.jupiter.api.*
import racingcar.domain.fixture.CustomNumberPicker

class CarTest {
    @Nested
    inner class ValidationTest {
        @Test
        @DisplayName("[Exception] name exceeds maximum name length")
        fun `test name length`() {
            val overLengthName = "dddddddd"
            assertThrows<IllegalArgumentException> { Car(overLengthName) }
        }

        @Test
        @DisplayName("[Exception] name contains spaces")
        fun `test name contains spaces`() {
            val containingSpace = "d d"
            assertThrows<IllegalArgumentException> { Car(containingSpace) }
        }

        @Test
        @DisplayName("[Exception] name is not alphanumeric")
        fun `test alphanumeric name`() {
            val noneAlphanumericName = "al3^3"
            assertThrows<IllegalArgumentException> { Car(noneAlphanumericName) }
        }
    }

    @Nested
    inner class MovingTest {
        @Test
        @DisplayName("[Success] when random number exceeds moving point, move")
        fun `test moving point`() {
            val testingCar: Car = Car("bonie", CustomNumberPicker.MovableNumberPicker)
            testingCar.move()
            Assertions.assertEquals(testingCar.getDistance(), 1)
        }

        @Test
        @DisplayName("[Exception] random number don't exceed moving point, then don't move")
        fun `test movable`() {
            val testingCar: Car = Car("bonie", CustomNumberPicker.UnmovableNumberPicker)
            testingCar.move()
            Assertions.assertEquals(testingCar.getDistance(), 0)
        }
    }
}
