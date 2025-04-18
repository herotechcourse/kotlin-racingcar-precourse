package racingcar

val RACE_RESULT_HEADER = "Race Results"
val MOVEMENT_MARK = "-"

/**
 * Handles the output of the racing game.
 */
class OutputHandler () {

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
}