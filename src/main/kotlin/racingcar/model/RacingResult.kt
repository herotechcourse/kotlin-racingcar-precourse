package racingcar.model

class RacingResult {
    private var winners: List<String>? = null
    fun getWinnerNames(cars: Cars): List<String> {
        val winnerPosition = cars.longestPosition
        return cars.getCars()
            .filter { it.position >= winnerPosition }
            .map { it.carName }
    }

    private fun determineRacingWinners(cars: Cars) {
        val winnerPosition = cars.longestPosition
        winners = cars.getCars().stream()
            .filter { car: Car -> car.position >= winnerPosition }
            .map(Car::carName)
            .toList()
    }
}
