package racingcar.domain

class FixedPowerGenerator(private val power: Int) : PowerGenerator {
    override fun generate(): Int {
        return power
    }
}
