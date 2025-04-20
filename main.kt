
// initiate the game 

class Application {
    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            CarRacingGame().start()
        }
    }
}

// implement main game functionality 

class CarRacingGame (
    fun start() {
        val cars = readCarNames ()
        val rounds = readRounds ()
        repeat (rounds) {
            println("\nRound ($it+1):")
            cars.forEach {it.moveIfPossible()}
        //    printRaceProgress(cars)
        }
        // announceWinners(cars)
    }
)