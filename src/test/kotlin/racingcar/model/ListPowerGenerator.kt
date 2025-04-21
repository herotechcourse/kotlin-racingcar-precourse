package racingcar.model

class ListPowerGenerator(private val values: List<Int>) : PowerGenerator {

    private var index = 0

    override fun generate(): Int {
        check(index < values.size) { "No more values to generate" }
        return values[index++]
    }

}

