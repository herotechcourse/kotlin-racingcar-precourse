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

    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `if the given number is 4 or more, the car moves`(condition: Int) {
        // given
        val alsongCar = Car("alsong")

        // when
        alsongCar.move(condition)

        // then
        assertThat(alsongCar.position).isEqualTo(1)
    }

    @ValueSource(ints = [0, 1, 2, 3])
    @ParameterizedTest
    fun `if the given number is 3 or less, the car doesn't move`(condition: Int) {
        // given
        val alsongCar = Car("alsong")

        // when
        alsongCar.move(condition)

        // then
        assertThat(alsongCar.position).isEqualTo(0)
    }
}
