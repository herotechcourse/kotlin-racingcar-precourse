import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import racingcar.domain.Car
import org.assertj.core.api.Assertions.*

class CarTest {
    @Nested
    @DisplayName("Initialization tests")
    inner class InitializationTests() {
        @Test
        @DisplayName("Should initialize Car with a name as read-only and a zero initialized IntArray with size == rounds")
        fun initializeCar() {
            val car = Car("car1", 5)
            assertThat(car.name).isEqualTo("car1")
            assertThat(car.moveHistory.size).isEqualTo(5)
            assertThat(car.moveHistory.all { !it }).isTrue()
        }
    }

    @Nested
}