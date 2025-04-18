package racingcar.io

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputParserTest {

    @Nested
    @DisplayName("readCarNames()")
    inner class ReadCarNamesTest {

        @Test
        fun `should return list of cars if input is valid`() {
            val result = InputParser.readCarNames("pobi,woni,jun")
            val carNames = result.map { it.name }

            assertEquals(listOf("pobi", "woni", "jun"), carNames)
        }

        @Test
        fun `should trim spaces from each car name`() {
            val result = InputParser.readCarNames("  pobi ,  woni ,jun  ")
            val carNames = result.map { it.name }

            assertEquals(listOf("pobi", "woni", "jun"), carNames)
        }

        @ParameterizedTest
        @ValueSource(strings = ["", "   "])
        fun `should throw exception if input is blank or only spaces`(input: String) {
            assertThrows<IllegalArgumentException> {
                InputParser.readCarNames(input)
            }
        }

        @ParameterizedTest(name = "{0}")
        @ValueSource(strings = ["pobi,pobi", "woni,woni,jun", "a,a,a"])
        fun `should throw exception if there are duplicate car names`(input: String) {
            assertThrows<IllegalArgumentException> {
                InputParser.readCarNames(input)
            }
        }
        
    }

    @Nested
    @DisplayName("readRound()")
    inner class ReadRoundTest {

        @ParameterizedTest(name = "{0}")
        @ValueSource(strings = ["1", "3", "10"])
        fun `should return round number if input is valid`(input: String) {
            val result = InputParser.readRound(input)

            assertEquals(input.toInt(), result)
        }

        @ParameterizedTest(name = "{0}")
        @ValueSource(strings = ["0", "-1", "-5"])
        fun `should throw exception if input is zero or negative`(input: String) {
            assertThrows<IllegalArgumentException> {
                InputParser.readRound(input)
            }
        }

        @ParameterizedTest(name = "{0}")
        @ValueSource(strings = ["abc", "1.5", "five"])
        fun `should throw exception if input is not a valid integer`(input: String) {
            assertThrows<IllegalArgumentException> {
                InputParser.readRound(input)
            }
        }

        @ParameterizedTest
        @ValueSource(strings = ["", "   "])
        fun `should throw exception if input is blank or only spaces`(input: String) {
            assertThrows<IllegalArgumentException> {
                InputParser.readRound(input)
            }
        }

    }

}