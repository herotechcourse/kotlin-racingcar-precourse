package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {

	@Test
	fun `car moves one step when moveIf is true`() {
		val car = Car("guri")
		car.moveIf(true)
		assertThat(car.totalDistance()).isEqualTo(1)
	}

	@Test
	fun `car does not move when moveIf is false`() {
		val car = Car("guri")
		car.moveIf(false)
		assertThat(car.totalDistance()).isEqualTo(0)
	}

	@Test
	fun `car position by round returns correct sum`() {
		val car = Car("guri")
		car.moveIf(true)    // round 1 [1]       -> 1
		car.moveIf(false)   // round 2 [1, 0]    -> 1
		car.moveIf(true)    // round 3 [1, 0, 1] -> 2
		assertThat(car.distanceUntil(1)).isEqualTo(1)
		assertThat(car.distanceUntil(2)).isEqualTo(1)
		assertThat(car.distanceUntil(3)).isEqualTo(2)
	}

	@Test
	fun `car creation fails if name is too long`() {
		assertThrows<IllegalArgumentException> {
			Car("guriHasTooLongName")
		}
	}

	@Test
	fun `distanceUntil throws if round is less than 1`() {
		val car = Car("guri")
		car.moveIf(true)
		assertThrows<IllegalArgumentException> {
			car.distanceUntil(0) // round = 0
		}
	}

	@Test
	fun `distanceUntil throws if round is greater than move size`() {
		val car = Car("guri")
		car.moveIf(true)
		assertThrows<IllegalArgumentException> {
			car.distanceUntil(2) // only 1 round exists
		}
	}

	@Test
	fun `didMoveAt returns true when moved`() {
		val car = Car("guri")
		car.moveIf(true) // round 1
		assertThat(car.didMoveAt(1)).isTrue()
	}

	@Test
	fun `didMoveAt returns false when not moved`() {
		val car = Car("guri")
		car.moveIf(false) // round 1
		assertThat(car.didMoveAt(1)).isFalse()
	}

	@Test
	fun `didMoveAt throws when round is out of bounds`() {
		val car = Car("guri")
		car.moveIf(true)
		assertThrows<IllegalArgumentException> {
			car.didMoveAt(2)
		}
	}

	@Test
	fun `hasMove returns true if any movement occurred`() {
		val car = Car("guri")
		car.moveIf(false)
		car.moveIf(true)
		assertThat(car.hasMove()).isTrue()
	}

	@Test
	fun `hasMove returns false if no movement occurred`() {
		val car = Car("guri")
		car.moveIf(false)
		car.moveIf(false)
		assertThat(car.hasMove()).isFalse()
	}
}