package racingcar.domain

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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
    }
}