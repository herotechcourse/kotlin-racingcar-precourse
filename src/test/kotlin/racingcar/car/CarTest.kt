package racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import racingcar.strategy.MoveStrategy

class CarTest {

    private val alwaysMove = MoveStrategy { true }
    private val neverMove = MoveStrategy { false }

    @Test
    @DisplayName("new car has position 0 by default")
    fun initialPositionIsZero() {
        val car = Car(name = "TestCar")
        assertThat(car.position())
            .`as`("A newly created car should start at position 0")
            .isZero
    }

    @Nested
    @DisplayName("move(strategy) updates position correctly")
    inner class MoveBehavior {

        @Test
        fun `increments position when strategy allows`() {
            val car = Car(name = "woni")
            car.move(alwaysMove)
            assertThat(car.position())
                .`as`("position should go from 0 to 1 when canMove is true")
                .isEqualTo(1)
        }

        @Test
        fun `does not change position when strategy denies`() {
            val car = Car(name = "jun")
            car.move(neverMove)
            assertThat(car.position())
                .`as`("position should remain 0 when canMove is false")
                .isZero
        }

        @Test
        fun `multiple moves accumulate position`() {
            val car = Car(name = "pobi")
            repeat(3) { car.move(alwaysMove) }
            assertThat(car.position())
                .`as`("three successful moves should bring position to 3")
                .isEqualTo(3)
        }

        @Test
        fun `interleaved moves respect strategy each time`() {
            val car = Car(name = "pobi")
            car.move(alwaysMove)
            car.move(neverMove)
            car.move(alwaysMove)

            assertThat(car.position())
                .`as`("should have moved twice out of three calls")
                .isEqualTo(2)
        }

        @Test
        fun `starting from non-zero initial position`() {
            val car = Car(name = "woni", position = 5)
            car.move(alwaysMove)
            assertThat(car.position())
                .`as`("initial position 5 + 1 successful move = 6")
                .isEqualTo(6)
        }
    }

    @Test
    @DisplayName("name property is preserved")
    fun nameIsImmutable() {
        val car = Car(name = "Porsche", position = 2)
        assertThat(car.name)
            .`as`("the name passed in constructor should be retrievable")
            .isEqualTo("Porsche")
    }
}