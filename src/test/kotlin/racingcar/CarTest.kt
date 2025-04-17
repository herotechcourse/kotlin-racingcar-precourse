package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `should have position 0 when car is initialized`() {
        // Given
        val car = Car("pobi")

        // When & Then
        assertThat(car.name).isEqualTo("pobi")
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `should increase position by 1 when movedForward is called`() {
        // Given
        var car = Car("woni")

        // When
        car = car.movedForward()

        // Then
        assertThat(car.name).isEqualTo("woni")
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `should return empty progress string when position is 0`() {
        // Given
        val car = Car("jun")

        // When & Then
        assertThat(car.toString()).isEqualTo("jun : ")
    }

    @Test
    fun `should return one dash in progress string when position is 1`() {
        // Given
        var car = Car("pobi")

        // When
        car = car.movedForward()

        // Then
        assertThat(car.toString()).isEqualTo("pobi : -")
    }

    @Test
    fun `should have position 2 when movedForward is called twice`() {
        // Given
        var car = Car("woni")

        // When
        repeat(2) {
            car = car.movedForward()
        }

        // Then
        assertThat(car.name).isEqualTo("woni")
        assertThat(car.position).isEqualTo(2)
    }

    @Test
    fun `should return three dashes in progress string when moved forward three times`() {
        // Given
        var car = Car("jun")

        // When
        repeat(3) {
            car = car.movedForward()
        }

        // Then
        assertThat(car.toString()).isEqualTo("jun : ---")
    }
}