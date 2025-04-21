package racingcar.model

class RacingCar(
    private val name: String,
    private val position: Int
) {
    constructor(name: String) : this(name, 0)
}