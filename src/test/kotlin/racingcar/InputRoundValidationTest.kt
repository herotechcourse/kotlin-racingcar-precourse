package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals

class InputRoundValidationTest {

 @Test
  fun `non integer number error`() {
   val input = "o"
   assertThrows<IllegalArgumentException> {
    validateRounds(input)
   }
  }

 @Test
 fun `negative number error`() {
   val input = "-1"
   assertThrows<IllegalArgumentException> {
    validateRounds(input)
   }
 }

 @Test
 fun `zero number error`() {
   val input = "0"
   assertThrows<IllegalArgumentException> {
       validateRounds(input)
   }
 }

    @Test
    fun validInput() {
        val input = "3"
        val result = validateRounds(input)
        assertEquals(result ,3)
    }
 }