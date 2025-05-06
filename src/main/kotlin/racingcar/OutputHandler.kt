package racingcar

class OutputHandler () {

    fun printRaceHeader() {
        println()
        println(RACE_RESULT_HEADER)
    }

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

    fun printWinners(winners: List<String>) {
        print(RACE_WINNER_MESSAGE)
        println(winners.joinToString(", "))
    }

    companion object{
        const val RACE_RESULT_HEADER = "Race Results"
        const val RACE_WINNER_MESSAGE = "Winners : "
        const val MOVEMENT_MARK = "-"
    }
}