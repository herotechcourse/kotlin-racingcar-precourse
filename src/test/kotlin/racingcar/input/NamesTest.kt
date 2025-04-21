package racingcar.input

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NamesTest {

  // VALIDATION TESTS
  @Test
  fun `passes validation on perfectly written input`() {
    Names.getInput("betty,lun90")
  }

  @Test
  fun `passes when names contain mixed casing and extra spaces around each name`() {
    val result = Names.getInput("  AnNa  ,   bOB ,  CARL ")
    assert(result == listOf("anna", "bob", "carl"))
  }

  @Test
  fun `parses all names to lowercase to facilitate duplicate check in validation method`() {
    val result = Names.getInput("BoB,ALICE")
    assertThat(result).containsExactly("bob", "alice")
  }

  @Test
  fun `trims whitespace around names`() {
    val result = Names.getInput("   alice  ,   bob ")
    assertThat(result).containsExactly("alice", "bob")
  }

  // EXCEPTION TESTS
  @Test
  fun `exception when input is empty`() {
    assertThrows<IllegalArgumentException> { Names.getInput("") }
  }

  @Test
  fun `exception when input is blank`() {
    assertThrows<IllegalArgumentException> { Names.getInput("     ") }
  }

  @Test
  fun `exception when only one car name is provided`() {
    assertThrows<IllegalArgumentException> { Names.getInput("car1") }
  }

  @Test
  fun `exception when a car name is empty`() {
    assertThrows<IllegalArgumentException> { Names.getInput("car1,,car3") }
  }

  @Test
  fun `exception when a car name contains only whitespace`() {
    assertThrows<IllegalArgumentException> { Names.getInput("car1,    ,car3") }
  }

  @Test
  fun `exception when a car name is split by space`() {
    assertThrows<IllegalArgumentException> { Names.getInput("car1,car 2, car3") }
  }

  @Test
  fun `exception when car name exceeds 5-character limit`() {
    assertThrows<IllegalArgumentException> { Names.getInput("jessica, angel, lola") }
  }

  @Test
  fun `exception when there are duplicate car names`() {
    assertThrows<IllegalArgumentException> { Names.getInput("mike , angel , ANGEL") }
  }

  /* Added to prevent users to write unreadable names (example: "\^_-/") or shell-sensitive
  characters (e.g. symbols only, ?, |, $)*/
  @Test
  fun `exception when car names include symbols or shell sensitive characters`() {
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
