package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceExecutionTest {

    @Test
    fun `when input is valid buildCarProgress returns properly formatted string`() {
        val expectedString = "pobi : ----"

        val actualString = buildCarProgress("pobi", 4)

        assertThat(actualString).isEqualTo(expectedString)
    }

    @Test
    fun `when input is valid determineWinners returns valid list of String`() {
        val listOfCarNames = listOf("pobi","woni","jun")
        val carPosition = mapOf("pobi" to 2,
            "woni" to 3,
            "jun" to 5,
        )
        val expectedResult = listOf("jun")

        val actualResult = determineWinners(listOfCarNames,carPosition)

        assertThat(actualResult).isEqualTo(expectedResult)
    }
}