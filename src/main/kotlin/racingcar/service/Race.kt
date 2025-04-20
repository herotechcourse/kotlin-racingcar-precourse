package racingcar.service
import racingcar.model.Car
import racingcar.io.RaceDisplay
import camp.nextstep.edu.missionutils.Randoms

class Race(
    val cars: List<Car>,
    val numberOfRounds: Int
) {
    companion object {
        private const val RANDOM_NUMBER_LOWER_BOUND = 0
        private const val RANDOM_NUMBER_UPPER_BOUND = 9
        private const val MOVE_THRESHOLD = 4

        fun createRaceSession(carNames: List<String>, numberOfRounds: Int): Race{
            return Race(carNames.map { carName -> Car(carName) }, numberOfRounds)
        }
    }

    fun startRace(){
        repeat(this.numberOfRounds){ lap ->
            runLap(lap + 1)
        }
        // display winner(s) after finishing the race
        RaceDisplay.displayRaceWinners(cars, getLeadPosition())
    }


    // ######################################## HELPER FUNCTIONS ########################################
    private fun runLap(lapNumber: Int){
        this.cars.forEach { car ->
            if (this.canMove()){
                car.moveForward()
            }
        }
        // display progress after each round
        RaceDisplay.displayLapProgress(this.cars, lapNumber)
    }

    private fun canMove(): Boolean{
        return Randoms.pickNumberInRange(RANDOM_NUMBER_LOWER_BOUND, RANDOM_NUMBER_UPPER_BOUND) >= MOVE_THRESHOLD
    }

    private fun getLeadPosition(): Int{
        return this.cars.maxOf { car -> car.position }
    }
}