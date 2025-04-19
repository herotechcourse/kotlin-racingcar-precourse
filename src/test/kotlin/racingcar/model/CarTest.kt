package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ValueSource(strings = ["alsong", "dalsong", "hasong", "tosong"])
    @ParameterizedTest
    fun `car has a name`(names: String) {
        // given
        val alsongCar = Car(names)

        // then
        assertThat(alsongCar.name).isEqualTo(names)
    }

    @Test
    fun `car has a position and default position is 0`() {
        // given
        val alsongCar = Car("alsong")

        // then
        assertThat(alsongCar.position).isEqualTo(0)
    }
}
