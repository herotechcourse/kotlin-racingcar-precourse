package racingcar.domain

import racingcar.util.RandomNumberGenerator

class Car(private val name: String) {

    companion object {
        private const val STANDARD_NUMBER = 4
    }

    private var distance: Int = 0

    fun move() {
        if (RandomNumberGenerator.generateRandomNumber() >= STANDARD_NUMBER) {
            distance++
        }
    }

    fun show() {
        val result = "$name : " + "-".repeat(distance)
        println(result)
    }

    fun getName(): String = name

    fun getDistance(): Int = distance
}