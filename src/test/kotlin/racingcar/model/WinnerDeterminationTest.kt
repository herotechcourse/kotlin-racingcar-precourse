package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class WinnerDeterminationTest {

    @Test
    @DisplayName("given multiple cars tied for max position when findWinners then returns all tied names")
    fun `given cars tied for max position when findWinners then returns all tied names`() {
        // given
        val carA = Car(name = "A", position = 3)
        val carB = Car(name = "B", position = 5)
        val carC = Car(name = "C", position = 5)
        val cars = Cars(listOf(carA, carB, carC))

        // when
        val winners = cars.findWinners()

        // then
        assertEquals(listOf("B", "C"), winners)
    }

    @Test
    @DisplayName("given single highest position when findWinners then returns single name")
    fun `given single highest position when findWinners then returns single name`() {
        // given
        val carA = Car(name = "A", position = 2)
        val carB = Car(name = "B", position = 4)
        val cars = Cars(listOf(carA, carB))

        // when
        val winners = cars.findWinners()

        // then
        assertEquals(listOf("B"), winners)
    }
}