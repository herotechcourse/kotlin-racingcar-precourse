package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*


class CarTest {

    @Test
    fun carNameMustNotBeEmpty() {
        assertThatIllegalArgumentException().isThrownBy { Car("") }.withMessage("Car name must not be empty")
    }

    @Test
    fun carNameLengthMustNotBeMoreThanFive() {
        assertThatIllegalArgumentException().isThrownBy { Car("qwerty") }
            .withMessage("Car name must not exceed 5 characters")
    }

    @Test
    fun validCarName() {
        Car("happy")
    }
}
