package racingcar.car

class Car(val carName: String,
          private val moveStrategy: MoveStrategy = RandomMoveStrategy()) {
    init {
        require(carName.length < 6)
    }

    /**
     * Represents the number of times the car has moved
     * Each '-' character represents one movement
     * ex: "--" mean car has moved twice
     */
    var position: String = ""

    fun drive(): String {
        if(moveStrategy.shouldMove()){
            position += "-"
        }
        return position
    }
}