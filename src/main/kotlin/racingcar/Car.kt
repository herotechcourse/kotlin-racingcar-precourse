package racingcar

class Car (val name: String) {
    var steps: Int = 0

    init {
        if (name.length > 5) {
            throw IllegalArgumentException("Name cannot exceed 5 characters")
        }
    }

    fun move() {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (randomNumber >= 4) {
            steps++;
        }
    }

    fun printRound() {
        print("$name : ")
        repeat (steps) {
            print("-")
        }
        println()
    }

    fun getSteps(): Int {
        return steps
    }
}