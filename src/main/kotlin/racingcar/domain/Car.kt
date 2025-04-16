package racingcar.domain

class Car private constructor(
    private val carName: CarName,
    private val position: Position
) {

    fun name(): String = carName.value()
    fun position(): Int = position.value()

    fun forward() {
        position.forward()
    }

    companion object {
        fun from(carName: CarName): Car {
            return Car(carName, Position.from())
        }
    }
}