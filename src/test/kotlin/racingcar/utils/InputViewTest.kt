package racingcar.utils

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import racingcar.utlls.InputView

class InputViewTest {

  // parseCarNamesInput
  // 1. Should parse a comma-separated list of car names correctly
  @Test
  fun testParseCarNamesInput_shouldParseCorrectly() {
   val input = "pobi,woni,jun"
   val result = InputView.parseCarNamesInput(input)
   assertEquals(listOf("pobi", "woni", "jun"), result)
  }

  // 2. At least one car name must be provided
  @Test
  fun testParseCarNamesInput_throwsExceptionIfAnyCarIsMissing() {
   val input = ""
   assertThrows<IllegalArgumentException> { InputView.parseCarNamesInput(input) }
  }

  // 3. Cars name cannot be empty
    @Test
    fun testParseCarNamesInput_throwsExceptionIfAnyCarNameIsEmpty() {
     val input = "pobi,,woni"
     assertThrows<IllegalArgumentException> { InputView.parseCarNamesInput(input) }
    }

  // 4. Car names cannot exceed 5 characters
    @Test
    fun testParseCarNamesInput_throwsExceptionIfAnyCarNameExceeds5Characters() {
     val input = "pobi,woni,123456"
     assertThrows<IllegalArgumentException> { InputView.parseCarNamesInput(input) }
    }

    // parseRoundCountInput
    // 1. Should read and parse the number of rounds correctly
    @Test
    fun testParseRoundCountInput() {
        val input = "3"
        val result = InputView.parseRoundCount(input)
        assertEquals(3, result)
    }

    // 2. Should throw an exception if the input is not a valid positive number
    @Test
    fun testReadAndParseRoundCountInput_throwsExceptionIfNegativeInput() {
        assertThrows<IllegalArgumentException> { InputView.parseRoundCount("0") }
        assertThrows<IllegalArgumentException> { InputView.parseRoundCount("-1") }
    }
}