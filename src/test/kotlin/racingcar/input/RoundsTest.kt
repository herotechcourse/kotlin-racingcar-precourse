package racingcar.input

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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

}
