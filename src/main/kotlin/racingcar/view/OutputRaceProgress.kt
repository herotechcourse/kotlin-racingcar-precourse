package racingcar.view
import racingcar.domain.Cars

object OutputRaceProgress {
    fun showRace(cars: Cars) {
        cars.getCarStates().forEach { (name, position) ->
            println("$name : ${"-".repeat(position)}")
        }
        println()
    }
}