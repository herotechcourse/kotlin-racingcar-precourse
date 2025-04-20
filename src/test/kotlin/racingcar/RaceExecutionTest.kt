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

}