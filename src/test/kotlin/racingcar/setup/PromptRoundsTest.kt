package racingcar.setup

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PromptRoundsTest {

  // VALIDATION TESTS
  @Test
  fun `passes validation when totalRounds is within system-safe limit of 10`() {
    PromptRounds.getInput("10")
  }

  @Test
  fun `passes validation when totalPromptRounds is set to minimum allowed value`() {
    PromptRounds.getInput("1")
  }

  @Test
  fun `trims whitespace around round number`() {
    val result = PromptRounds.getInput("   2   ")
    assertThat(result).isEqualTo(2)
  }

  // EXCEPTION TESTS

  @Test
  fun `exception when totalPromptRounds is zero`() {
    assertThrows<IllegalArgumentException> { PromptRounds.getInput("0") }
  }

  @Test
  fun `exception when totalPromptRounds is a negative value`() {
    assertThrows<IllegalArgumentException> { PromptRounds.getInput("-1") }
  }

  // Added to prevent UI overload during race simulation
  @Test
  fun `exception when totalPromptRounds exceeds system-safe limit of 10`() {
    assertThrows<IllegalArgumentException> { PromptRounds.getInput("11") }
  }

  @Test
  fun `exception when totalPromptRounds is a non-integer value`() {
    assertThrows<IllegalArgumentException> { PromptRounds.getInput("abc") }
  }

  @Test
  fun `exception when totalPromptRounds is a decimal value`() {
    assertThrows<IllegalArgumentException> { PromptRounds.getInput("1.5") }
  }

  @Test
  fun `exception when value contains more than a number`() {
    assertThrows<IllegalArgumentException> { PromptRounds.getInput("1 7") }
  }

  @Test
  fun `exception when input is blank`() {
    assertThrows<IllegalArgumentException> { PromptRounds.getInput("") }
  }
}
