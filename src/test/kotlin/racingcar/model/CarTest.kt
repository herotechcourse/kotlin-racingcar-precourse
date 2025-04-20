import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import racingcar.model.Car
import racingcar.model.Constants


class CarTest {
    @Test
    fun `car moves when random number is greater than or equal to minimum`() {
        val car = Car("car")
        val didMove = car.move(Constants.MIN_MOVE_VALUE)
        assertThat(didMove).isTrue()
        assertThat(car.getPosition()).isEqualTo(1)
    }
}