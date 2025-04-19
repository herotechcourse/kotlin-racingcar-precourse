package racingcar.model

class Car(val name: String) {
    private var position = 0

    fun move(randomValue: Int): Boolean {
        val didMove = randomValue >= Constants.MIN_MOVE_VALUE
        if(didMove){
            position++
        }
        return didMove
    }

    fun getPosition() = position

    fun isWinner(maxPosition: Int): Boolean {
        return position == maxPosition
    }
}