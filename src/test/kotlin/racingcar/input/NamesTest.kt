package racingcar.input

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NamesTest {

  // VALIDATION TESTS
  @Test
  fun `passes validation when input has valid characters, name length and enough cars to compete in the race`() {
    Names.getInput("  betty  , luna  ")
  }

  // EXCEPTION TESTS
  @Test
  fun `exception when list is empty`() {
    assertThrows<IllegalArgumentException> { Names.getInput("") }
  }

  @Test
  fun `exception when only one car name is provided`() {
    assertThrows<IllegalArgumentException> { Names.getInput("car1") }
  }

  @Test
  fun `exception when a car name is empty`() {
    assertThrows<IllegalArgumentException> {
      Names.getInput("car1,,car3")
    }
  }

  @Test
  fun `exception when a car name contains only whitespace characters`() {
    assertThrows<IllegalArgumentException> {
      Names.getInput("car1,   ,car3")
    }
  }

  @Test
  fun `exception when a car name is split by space`() {
    assertThrows<IllegalArgumentException> {
      Names.getInput("car1, car 2, car3")
    }
  }

  @Test
  fun `exception when car name exceeds 5-character limit`() {
    assertThrows<IllegalArgumentException> {
      Names.getInput("jessica, angel, lola")
    }
  }

  @Test
  fun `exception when there are duplicate car names`() {
    assertThrows<IllegalArgumentException> {
      Names.getInput("mike , angel , ANGEL")
    }
  }

  // Added to Prevent use of unreadable or shell-sensitive characters (e.g. symbols only, ?, |, $)
  @Test
  fun `exception when car names use unreadable or shell sensitive characters`() {
    assertThrows<IllegalArgumentException> { Names.getInput("car? , car1") }
  }

  // Added to prevent UI overload during race simulation
  @Test
  fun `exception when number of car names exceeds system-safe limit of 10`() {
    assertThrows<IllegalArgumentException> {
      val cars = (1..11).map { "car$it" }.joinToString(",")
      Names.getInput(cars)
    }
  }
}
