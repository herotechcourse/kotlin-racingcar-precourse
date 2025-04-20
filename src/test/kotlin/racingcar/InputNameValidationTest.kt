package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputNameValidationTest {

  @Test
  fun `empty name error`() {
    val input = "Hello, Jello, , Mello".split(",", ignoreCase = true, limit = 0)
    assertThrows<IllegalArgumentException> {
     validateCarNames(input) }
  }

  @Test
  fun `name length error`(){
      val input = "Helloo, Jellooo, Mello".split(",", ignoreCase = true, limit = 0)
      assertThrows<IllegalArgumentException> {
        validateCarNames(input)
      }
  }

  @Test
  fun `duplicated name error`(){
      val input = "hello, hello, HELLO".split(",", ignoreCase = true, limit = 0)
      assertThrows<IllegalArgumentException> {
        validateCarNames(input)
      }
  }
 }