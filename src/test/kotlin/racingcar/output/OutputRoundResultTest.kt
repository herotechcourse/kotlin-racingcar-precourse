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

class OutputRoundResultTest {
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
}