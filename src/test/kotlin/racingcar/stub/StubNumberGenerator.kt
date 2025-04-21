package racingcar.stub

import racingcar.domain.generator.NumberGenerator

class StubNumberGenerator(private val fixed: Int): NumberGenerator {

    override fun nextInt(min: Int, max: Int) = fixed
}
