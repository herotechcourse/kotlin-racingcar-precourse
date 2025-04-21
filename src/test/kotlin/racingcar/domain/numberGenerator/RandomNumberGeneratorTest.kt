package racingcar.domain.numberGenerator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.numbergenerator.RandomNumberGenerator

class RandomNumberGeneratorTest {

    @Test
    fun `should return number within range`() {
        // given
        val randomNumberGenerator = RandomNumberGenerator()
        // when
        val result = randomNumberGenerator.generate()
        // then
        assertThat(result).isBetween(START_RANGE, END_RANGE)
    }

    companion object {
        private const val START_RANGE: Int = 0
        private const val END_RANGE: Int = 9
    }
}
