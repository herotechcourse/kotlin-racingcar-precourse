package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ValueSource(strings = ["alsong", "dalsong", "hasong", "tosong"])
    @ParameterizedTest
    fun `Car have a name`(names: String) {
        // given
        val alsongCar = Car(names)

        // then
        assertThat(alsongCar.name).isEqualTo(names)
    }
}
