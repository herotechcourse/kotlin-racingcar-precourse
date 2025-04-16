package racingcar.domain.car

class Car(
    private val name: Name,
    private val position: Position
) {
    fun move() {
        position.increase()
    }

    fun getName(): String {
        return name.getName()
    }

    fun getPosition(): Int {
        return position.getPosition()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Car) return false

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}
