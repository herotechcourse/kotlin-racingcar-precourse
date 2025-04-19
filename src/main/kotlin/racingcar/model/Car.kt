package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import kotlin.random.Random

data class Car(val name:String) {
    private var position = 0

    fun validateName(name: String) {
        if (name.isEmpty()){
            throw IllegalArgumentException("Car name cannot be empty")
        }
        if (name.length > 5) {
            throw IllegalArgumentException("Car name cannot exceed 5 characters: $name")
        }
    }
    fun moveForward() {
        if (shouldMove()) {
            position++
    }

    fun displayProgress(): String {
        return "$name: ${"-".repeat(position)}"
    }
}

    private fun shouldMove(): Boolean {
        return Randoms.pickNumberInRange(0,9) >= 4
    }

    fun getPosition(): Int{
        return position
    }}
