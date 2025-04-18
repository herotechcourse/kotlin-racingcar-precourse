package racingcar.domain

class Referee(val cars: Cars) {

    fun determineWinner(): List<String> {
        val maxPosition = cars.getMaxPosition()
        return cars.findAllAtPosition(maxPosition)
            .map { it.getName() }
    }
}
