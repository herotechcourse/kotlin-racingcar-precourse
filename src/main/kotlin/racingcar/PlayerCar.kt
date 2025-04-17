package racingcar

data class PlayerCar(
    val name: String
) {
    private var distance = 0

    private fun canMove(randomNum: Int): Boolean {
        return randomNum >= 4
    }

    fun movingForward() {
        distance += 1
    }
}