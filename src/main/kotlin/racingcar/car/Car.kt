package racingcar.car

import kotlin.random.Random

class Car(val carName: String) {
    init {
        require(carName.length < 5)
    }
    private var position: Int = 0
    fun drive() {
        val randomNumber = Random.nextInt(10)
        if (randomNumber > 3) {
            position++
        }
    }
    fun getPosition(): Int{
        return position
    }
}