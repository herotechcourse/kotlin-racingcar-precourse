package racingcar.domain

import racingcar.domain.generator.NumberGenerator
import racingcar.domain.generator.RandomNumberGenerator

class RandomMoveStrategy (
    private val generator: NumberGenerator = RandomNumberGenerator()
) {

    fun getDistance(): Int =
        if (generator.nextInt(0, 9) > 3)  1 else 0
}
