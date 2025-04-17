package racingcar

data class PlayerCar(
    val name: String
) {
    var distance = 0
        private set

    private fun canMove(randomNum: Int): Boolean {
        return randomNum >= 4
    }

    fun movingForward(num: Int) {
        if (canMove(num)) {
            distance += 1
        }
    }

}