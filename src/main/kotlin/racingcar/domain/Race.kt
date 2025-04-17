package racingcar.domain

// Library Randoms from subject req
import camp.nextstep.edu.missionutils.Randoms

class Race(private val cars: List<Car>, private val rounds: Int) {
    fun run(): List<Car> {
        repeat(rounds) {
            executeRound()
        }
        return determineWinners()
    }

    // method should move each car based on the random number generation rule
    // cars move if a random number between 0-9 is 4 or greater
    private fun executeRound() {
        cars.forEach { car ->
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            car.move(randomNumber)
        }
    }

    // method should find the car(s) that have moved the furthest
    private fun determineWinners(): List<Car> {
        val maxPosition = cars.maxOfOrNull { it.getPosition() } ?: 0
        // goes through car elements and calls getPosition on each car
        // returns max value or null if empty
        return cars.filter { it.getPosition() == maxPosition }
        // filter creates a new list that meets the condition
        // the condition: if car pos is the max pos
    }
}