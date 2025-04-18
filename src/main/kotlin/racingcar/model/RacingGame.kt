package racingcar.model

import racingcar.util.NumberGenerator
import racingcar.view.OutputView

// class that runs the whole racing game
// takes in cars and how many rounds to play
class RacingGame(
    private val cars: Cars,
    private val roundCount: Int
) {

    // this starts the race
    // calls moveCars() roundCount times
    fun start() {
        for (i in 1..roundCount) {
            val numbers = NumberGenerator.generate(carsSize())
            cars.moveCars(numbers)

            OutputView.printRoundResult(cars.getCars())
        }
    }git add src/main/kotlin/racingcar/model/Cars.kt

    // gets how many cars are in the race
    private fun carsSize(): Int {
        return cars.getCars().size
    }

    fun getWinners() : List<Car>{
        return cars.getWinners()
    }

}
