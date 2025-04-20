package racingcar.util

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class InputParserTest {

    @Test
    @DisplayName("given comma-separated names when parseCarName then returns trimmed name list")
    fun `given comma-separated names when parseCarName then returns trimmed name list`() {
        // given
        val input = "pobi, java , kim"

        // when
        val result = InputParser.parseCarName(input)

        // then
        assertEquals(listOf("pobi", "java", "kim"), result)
    }
}