package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test

class CarTest {

    @Nested
    @DisplayName("Car initialization")
    inner class CarInitialization {

        @Test
        @DisplayName("should initialize car with correct name")
        fun initializeWithName() {
            val carName = "TestCar"
            val car = Car(carName)
            assertThat(car.name).isEqualTo(carName)
        }

        @Test
        @DisplayName("should initialize car with zero progression")
        fun initializeWithZeroProgression() {
            val car = Car("TestCar")
            assertThat(car.progression).isZero()
        }
    }

    @Nested
    @DisplayName("Car progression")
    inner class CarProgression {

        @RepeatedTest(10)
        @DisplayName("progression should increase by at most 1 per call")
        fun progressionIncreasesByAtMostOne() {
            val car = Car("TestCar")
            val initialProgression = car.progression

            car.progress()
            assertThat(car.progression).isLessThanOrEqualTo(initialProgression + 1)
        }
    }
}
