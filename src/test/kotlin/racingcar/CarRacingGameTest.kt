package racingcar
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class CarTest {
    @Test
    fun `car should move only if random number is 4 or more`() {
        val car = Car("test")
        repeat(100) {
            car.move()
        }
        assertThat(car.position).isBetween(30, 70) // rough test
    }
}
