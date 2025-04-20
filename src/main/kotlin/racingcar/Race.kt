/**
 * Race class
 */

package racingcar

class RaceResult(val rounds: List<List<String>>, val winners: List<String>) {
    fun print() {
        println()
        println("Race Results")
        for (roundResult in this.rounds) {
            roundResult.map { println(it) }
            println()
        }
        println("Winners : ${this.winners.joinToString(", ")}")
    }
}

class FixedRoundsRace(private val config: FixedRoundsRaceConfiguration) {
    private val lanes = List(this.config.carNames.size) { Lane() }
    private val cars = this.config.carNames.mapIndexed { index, name -> Car(name, lanes[index]) }

    private fun getReady() {
        this.cars.map { it.getReady() }
    }

    private fun proceedRound() {
        cars.map { it.attemptMoveForward() }
    }

    private fun currentStatus() : List<String> {
        return cars.map { it.raceStatus() }
    }

    private fun currentWinners() : List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return if (maxPosition > 0) cars.filter { it.position == maxPosition } else emptyList()
    }

    fun run() : RaceResult {
        val roundResults = ArrayList<List<String>>()

        this.getReady()
        for (round in 1..config.nRounds) {
            this.proceedRound()
            roundResults.add(this.currentStatus())
        }
        return RaceResult(roundResults, this.currentWinners().map { it.name })
    }
}
