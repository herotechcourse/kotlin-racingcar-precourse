package racingcar.model

class Round(val count: Int, private val participants: List<Car>) {
    fun race() {
        participants.map { it.go() }
    }
}