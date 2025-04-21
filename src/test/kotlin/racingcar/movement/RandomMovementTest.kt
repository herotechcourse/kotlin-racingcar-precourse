package racingcar.movement

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*

class RandomMovementTest {
    @Test
    fun `shouldMove returns true if supplied number is 4 or greater`() {
        val move4 = RandomMovement { 4 }
        val move7 = RandomMovement { 7 }

        assertThat(move4.shouldMove()).isTrue()
        assertThat(move7.shouldMove()).isTrue()
    }

    @Test
    fun `shouldMove returns false if supplied number is less than 4`() {
        val move3 = RandomMovement { 3 }
        val move0 = RandomMovement { 0 }

        assertThat(move3.shouldMove()).isFalse()
        assertThat(move0.shouldMove()).isFalse()
    }
}