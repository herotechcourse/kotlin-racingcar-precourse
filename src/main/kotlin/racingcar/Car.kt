package racingcar

class Car(
    val name: String,
) {
    var position = 0

    fun move() {
        position += 1
    }

    companion object {
        fun isValidName(name: String): Boolean {
            return name.length <= 5
        }
    }
    
    override fun toString(): String {
        return "Car(name='$name', position=$position)"
    }
}
