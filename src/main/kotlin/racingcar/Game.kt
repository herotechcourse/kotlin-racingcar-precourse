package racingcar

import camp.nextstep.edu.missionutils.Randoms

data class Input(val cars: List<Car>, var totalRounds: Int) {
    init {
        require(cars.size > 0) { "cars cannot be empty" }
        require(totalRounds > 0) { "total rounds should be at-least one" }
    }
}

interface RandomNumberGenerator {
    fun pickNumberInRange(startInclusive: Int, endInclusive: Int): Int
}

data class Car(val name: String, var position: Int = 0) {
    init {
        require(name.length <= 5) { "name cannot exceed 5 characters: $name" }
    }

    fun move(movement: Int): Car {
        if (movement >= 4) {
            position++
        }
        return this
    }

    fun displayProgress(): Car {
        println("$name : ${"-".repeat(position)}")
        return this
    }
}

data class Game(val input: Input) {
    companion object {
        const val RANDOM_MIN_RANGE = 0
        const val RANDOM_MAX_RANGE = 9
    }

    fun run(customRandomGenerator: RandomNumberGenerator? = null) {
        println()
        println("Race Results")
        repeat(input.totalRounds) {
            val randomMove =
                    customRandomGenerator?.pickNumberInRange(RANDOM_MIN_RANGE, RANDOM_MAX_RANGE)
                            ?: Randoms.pickNumberInRange(RANDOM_MIN_RANGE, RANDOM_MAX_RANGE)

            input.cars.forEach { car -> car.move(randomMove).displayProgress() }
            println()
        }
        println()
        displayWinners()
    }

    fun displayWinners() {
        val maxPosition = input.cars.maxOf { it.position }
        val winners = input.cars.filter { it.position == maxPosition }
        println("Winners : ${winners.joinToString(", ") {it.name}}")
    }
}
