package racingcar.results

import racingcar.results.CarResult

// Class to determine the race
class RaceWinnerDeterminer {

    // To determine Winners
    fun determineWinners(carResults: List<CarResult>): List<String> {
        val maxPosition = findMaxPosition(carResults)
        return getWinnersAtPosition(carResults, maxPosition)
    }

    // Find the maximum position (distance covered)
    private fun findMaxPosition(carResults: List<CarResult>): Int {
        return carResults.maxOf { it.position }
    }

    // Get the cars that are at the maximum position
    private fun getWinnersAtPosition(carResults: List<CarResult>, maxPosition: Int): List<String> {
        return carResults.filter { it.position == maxPosition }
            .map { it.name }
    }
}