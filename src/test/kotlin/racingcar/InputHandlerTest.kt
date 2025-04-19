package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputHandlerTest {

  // validateCarNames TODO: implement parsing unit test
  // FEATURE TESTS
  @Test
  fun `passes validation when input has valid characters, name length and enough cars to compete in the race`() {
    val names = listOf("betty", "luna")
    InputHandler.validateCarNames(names)
  }

  @Test
  fun `passes validation when exactly 10 car names are provided`() {
    val cars = (1..10).map { "car$it" }
    InputHandler.validateCarNames(cars)
  }

  // EXCEPTION TESTS
  @Test
  fun `exception when list is empty`() {
    assertThrows<IllegalArgumentException> { InputHandler.validateCarNames(listOf("")) }
  }

  @Test
  fun `exception when a car name is empty`() {
    assertThrows<IllegalArgumentException> {
      InputHandler.validateCarNames(listOf("car1", "", "car3"))
    }
  }

  @Test
  fun `exception when only one car name is provided`() {
    assertThrows<IllegalArgumentException> { InputHandler.validateCarNames(listOf("car1")) }
  }

  @Test // TODO: validateCarNames() - might be more a parsing check than a name check
  fun `exception when a car name contains only whitespace characters`() {
    assertThrows<IllegalArgumentException> {
      InputHandler.validateCarNames(listOf("car1", "   ", "car3"))
    }
  }

  @Test
  fun `exception when a car name is split by space`() {
    assertThrows<IllegalArgumentException> {
      InputHandler.validateCarNames(listOf("car1", "car 2", "car3"))
    }
  }

  @Test
  fun `exception when car name exceeds 5-character limit`() {
    assertThrows<IllegalArgumentException> {
      InputHandler.validateCarNames(listOf("jessica, angel, lola"))
    }
  }

  @Test
  fun `exception when there are duplicate car names`() {
    assertThrows<IllegalArgumentException> {
      InputHandler.validateCarNames(listOf("mike", "angel", "angel"))
    }
  }

  // Added to Prevent use of unreadable or shell-sensitive characters (e.g. symbols only, ?, |, $)
  @Test
  fun `exception when car names use unreadable or shell sensitive characters`() {
    assertThrows<IllegalArgumentException> { InputHandler.validateCarNames(listOf("car?", "car1")) }
  }

  // Added to prevent UI overload during race simulation
  @Test
  fun `exception when number of car names exceeds system-safe limit of 10`() {
    assertThrows<IllegalArgumentException> {
      val cars = (1..11).map { "car$it" }
      InputHandler.validateCarNames(cars)
    }
  }

  // TOTAL ROUNDS TODO: implement parsing unit test
  // FEATURE TESTS
  @Test
  fun `passes validation when totalRounds is within system-safe limit of 10`() {
    InputHandler.validateTotalRounds(10)
  }

  @Test
  fun `passes validation when totalRounds is set to minimum allowed value`() {
    InputHandler.validateTotalRounds(1)
  }

  // exceptions

  @Test
  fun `exception when totalRounds is zero`() {
    assertThrows<IllegalArgumentException> { InputHandler.validateTotalRounds(0) }
  }

  @Test
  fun `exception when totalRounds is a negative value`() {
    assertThrows<IllegalArgumentException> { InputHandler.validateTotalRounds(-1) }
  }

  // Added to prevent UI overload during race simulation
  @Test
  fun `exception when totalRounds exceeds system-safe limit of 10`() {
    assertThrows<IllegalArgumentException> { InputHandler.validateTotalRounds(11) }
  }
}
