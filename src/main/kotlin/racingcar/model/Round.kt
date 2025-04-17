package racingcar.model

class Round(
    val count: Int,
    private val participants: List<Car>,
    private val roundResult: MutableMap<Car, Int> = HashMap()
) {
    fun race() {
        roundResult.clear()
        participants.forEach { car ->
            car.go()
            roundResult[car] = car.getStatus()
        }
    }

    fun getRoundResult(): Map<Car, Int> {
        return roundResult.toMap()
    }
}
