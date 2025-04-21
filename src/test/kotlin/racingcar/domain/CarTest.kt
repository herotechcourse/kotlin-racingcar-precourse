package racingcar.domain
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun moves_forward_when_random_number_is_4_or_greater() {
        val car = Car("pobi")
        car.move(4)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun does_not_move_when_random_number_is_3_or_less() {
        val car = Car("pobi")
        car.move(3)
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun throws_exception_when_car_name_exceeds_5_characters() {
        assertThatThrownBy { Car("abcdef") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Name_must_be_5_characters_or_less.")
    }
}