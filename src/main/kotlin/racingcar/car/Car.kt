package racingcar.car

import kotlin.random.Random

class Car(val carName: String) {
    init {
        require(carName.length < 5)
    }
    private var position: String = ""

    fun drive(): String {
        val randomNumber = Random.nextInt(10)
        if (randomNumber > 3) {
            position += "-"
        }
        return position
    }
}