package racingcar.domain
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `랜덤 숫자 4 이상이면 전진`() {
        val car = Car("pobi")
        car.move(4)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `랜덤 숫자 3 이하면 정지`() {
        val car = Car("pobi")
        car.move(3)
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `이름이 5자 초과일 경우 예외 발생`() {
        assertThatThrownBy { Car("abcdef") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("5자 이하")
    }
}