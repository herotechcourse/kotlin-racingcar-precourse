package racingcar.input

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat


class RoundsTest {

  // VALIDATION TESTS
  @Test
  fun `passes validation when totalRounds is within system-safe limit of 10`() {
    Rounds.getInput("10")
  }

  @Test
  fun `passes validation when totalRounds is set to minimum allowed value`() {
    Rounds.getInput("1")
  }

  @Test
  fun `trims whitespace around round number`() {
    val result = Rounds.getInput("   2   ")
    assertThat(result).isEqualTo(2)
  }

  // EXCEPTION TESTS

  @Test
  fun `exception when totalRounds is zero`() {
    assertThrows<IllegalArgumentException> { Rounds.getInput("0") }
  }

  @Test
  fun `exception when totalRounds is a negative value`() {
    assertThrows<IllegalArgumentException> { Rounds.getInput("-1") }
  }

  // Added to prevent UI overload during race simulation
  @Test
  fun `exception when totalRounds exceeds system-safe limit of 10`() {
    assertThrows<IllegalArgumentException> { Rounds.getInput("11") }
  }

  @Test
  fun `exception when totalRounds is a non-integer value`() {
    assertThrows<IllegalArgumentException> { Rounds.getInput("abc") }
  }

  @Test
  fun `exception when totalRounds is a decimal value`() {
    assertThrows<IllegalArgumentException> { Rounds.getInput("1.5") }
  }

  @Test
  fun `exception when value contains more than a number`() {
    assertThrows<IllegalArgumentException> { Rounds.getInput("1 7") }
  }

  @Test
  fun `exception when input is blank`() {
    assertThrows<IllegalArgumentException> { Rounds.getInput("") }
  }

}
