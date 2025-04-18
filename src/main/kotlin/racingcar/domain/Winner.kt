package racingcar.domain

class Winner {
    fun findWinner(cars : List<Car>): List<String> {
        var max = 0
        var winners = mutableListOf<Car>()
        for (car in cars) {
            if (max == car.getPosition()) {
                winners.add(car)
            }
            if (max < car.getPosition()) {
                winners = mutableListOf<Car>()
                winners.add(car)
                max = car.getPosition()
            }
        }
        return winners.stream().map {car -> car.getName()}.toList()
    }
}