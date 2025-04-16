package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.junit.jupiter.api.assertThrows

class CarNameTest {

    @Nested
    inner class `When creating CarName successfully` {

        @ParameterizedTest(name = "CarName: {0}")
        @ValueSource(strings = ["p", "po", "pob", "pobi", "pobiz"])
        fun `it should return CarName with given value`(input: String) {
            val carName = CarName.from(input)
            assertThat(carName.value()).isEqualTo(input)
        }
    }

    @Nested
    inner class `When CarName is invalid` {

        @ParameterizedTest(name = "too long CarName: {0}")
        @ValueSource(strings = ["jsoonw", "jsoonwo", "jsoonworld"])
        fun `it should throw IllegalArgumentException when length exceeds 5`(input: String) {
            val exception = assertThrows<IllegalArgumentException> {
                CarName.from(input)
            }
            assertThat(exception.message).isEqualTo(CarName.ERROR_EXCEED_LENGTH)
        }
    }
}
