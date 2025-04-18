package racingcar

import camp.nextstep.edu.missionutils.Randoms;

data class Input(val cars: List<Car>, var totalRounds: Int) {
    init {
        require(cars.size == 0) {"cars cannot be empty"}
        require(totalRounds <= 0) {"total rounds should be at-least one"}
    }
}

data class Car(val name: String, var position: Int = 0) {
    init {
        require(name.length <= 5) { "name cannot exceed 5 characters: $name" }
    }

    fun move(): Car {
        val randomMove = Randoms.pickNumberInRange(0, 9)
        if(randomMove >= 4) {
            position++
        }
        return this
    }

    fun displayProgress(): Car {
        println("$name : ${"-".repeat(position)}")
        return this
    }
}