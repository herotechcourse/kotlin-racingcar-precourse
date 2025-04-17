package racingcar.generator

class FixedRandomNumberGenerator(private val fixedValue: Int) : RandomNumberGenerator {

    override fun generate(): Int {
        return fixedValue
    }

}