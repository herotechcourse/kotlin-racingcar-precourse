package racingcar.output

/**
 *  [ Specification for Test ]
 *  = Check, format of output is written correctly.
 *
 *  [ Memo ]
 *  1. """
 *  = Raw String, allows multi-line strings to be written as it.
 *
 *  2. .trinmIndent()
 *  = Remove common indentation(gap) of multiline strings.
 */
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

data class Car(val name: String, val position: Int) // Later merge

class OutputEachRoundResultTest {
    // 1. Basic list test
    @Test
    fun `should return string as given format`() {
        val cars = listOf ( Car("pobi", 1),
                            Car("woni", 0),
                            Car("jun", 1)
        )

        val result = formatRoundResult(cars)
        val expected = """
            pobi : -
            woni : 
            jun : -
        """.trimIndent()

        assertEquals(expected, result)
    }

    // 2. Empty list test
    @Test
    fun `should return empty string for empty list`() {
        val cars = emptyList<Car>()

        val result = formatRoundResult(cars)
        val expected = ""

        assertEquals(expected, result)
    }

    // 3. Same position test
    @Test
    fun `should return same result`() {
        val cars = listOf(
            Car("pobi", 2),
            Car("woni", 2),
            Car("jun", 2)
        )

        val result = formatRoundResult(cars)
        val expected = """
            pobi : --
            woni : --
            jun : --
        """.trimIndent()

        assertEquals(expected, result)
    }

    // 4. Position is 0
    @Test
    fun `should return nothing, because all cars are at position 0`() {
        val cars = listOf(
            Car("pobi", 0),
            Car("woni", 0),
            Car("jun", 0)
        )

        val result = formatRoundResult(cars)
        val expected = """
            pobi : 
            woni : 
            jun : 
        """.trimIndent()

        assertEquals(expected, result)
    }
}