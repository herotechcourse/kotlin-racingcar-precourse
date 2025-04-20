package racingcar

class RaceController {

    private val raceInput = RoundsInput()

    fun startRace(carNames: List<String>) {
        val cars = carNames.map { Car(it) }
        val rounds = raceInput.inputRounds()
        race(cars, rounds)
        announceWinners(cars)
    }

    private fun race(cars: List<Car>, rounds: Int) {
        repeat(rounds) {
            println("\nRound ${it + 1}")
            executeRound(cars)
            displayRaceProgress(cars)
        }
    }

    private fun executeRound(cars: List<Car>) {
        cars.forEach { car -> car.move(randomNumberGenerator()) }
    }

    private fun displayRaceProgress(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
    }

    private fun announceWinners(cars: List<Car>) {
        println("\nFinal Result")
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }
        println("Winners : ${winners.joinToString(", ") { it.name }}")
    }

    private fun randomNumberGenerator(): Int {
        return (0..9).random()
    }


} 