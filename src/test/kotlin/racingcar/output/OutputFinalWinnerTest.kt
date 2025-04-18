package racingcar.output

/**
 *  [ Specification for Test ]
 *  1. Single winner
 *  2. Multiple winners
 */
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

data class Car(val name: String, val position: Int) // Later merge

class OutputFinalWinnerTest {
    // 1. Single winner
    @Test
    fun `Test1 - should print a single winner`() {
        val cars = listOf(
            Car("pobi", 3),
            Car("woni", 2),
            Car("jun", 1)
        )

        val result = outputFinalWinner(cars)

        val expected = "Winners : pobi"
        assertEquals(expected, result)
    }

    // 2. Multiple winners
    @Test
    fun `Test2 - should print multiple winners`() {
        val cars = listOf(
            Car("pobi", 3),
            Car("woni", 2),
            Car("jun", 3)
        )

        val result = outputFinalWinner(cars)

        val expected = "Winners : pobi, jun"
        assertEquals(expected, result)
    }
}
