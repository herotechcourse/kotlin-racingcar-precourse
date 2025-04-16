package racingcar.model

class Referee(
    private val participants: List<Car>,
    private val winners: MutableList<Car> = mutableListOf()
) {

    fun judge(): MutableList<Car> {
        winners.clear()
        var highestStatus = Int.MIN_VALUE

        participants.map { car ->
            if (car.getStatus() > highestStatus) {
                highestStatus = car.getStatus()
            }
        }
        participants.map { car ->
            if (car.getStatus() == highestStatus) {
                winners.add(car)
            }
        }
        return winners
    }
}