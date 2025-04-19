package racingcar.fixture

import racingcar.model.random.RandomNumberGenerator

class FakeRandomNumberGenerator(private val value: Int) : RandomNumberGenerator {
    override fun generate(): Int{
        return value
    }
}
