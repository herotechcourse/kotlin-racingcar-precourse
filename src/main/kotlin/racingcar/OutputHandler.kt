package racingcar

/**
 * Handles the output of the racing game.
 */
class OutputHandler () {

    companion object{
        val RACE_RESULT_HEADER = "Race Results"
        val RACE_WINNER_MESSAGE = "Winners : "
        val MOVEMENT_MARK = "-"
    }

    /**
     * Prints the race result header.
     */
    fun printRaceHeader() {
        println()
        println(RACE_RESULT_HEADER)
    }

    /**
     * Displays the race progress for each car. Each car's name and movement are printed.
     *
     * @param cars the list of cars participating in the race
     */
    fun printRaceProgress(cars: List<Car>) {
        for (car in cars) {
            print("${car.name} : ")
            repeat(car.movement) {
                print(MOVEMENT_MARK)
            }
            println()
        }
        println()
    }

    /**
     * Prints the winners of the race.
     *
     * @param winners a list of the names of the winning cars
     */
    fun printWinners(winners: List<String>) {
        print(RACE_WINNER_MESSAGE)
        println(winners.joinToString(", "))
    }
}