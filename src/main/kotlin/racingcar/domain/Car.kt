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

    fun copy(): Car {
        val copied = Car.from(CarName.from(name()))
        repeat(position()) { copied.forward() }
        return copied
    }

    companion object {
        fun from(carName: CarName): Car {
            return Car(carName, Position.from())
        }
    }
}