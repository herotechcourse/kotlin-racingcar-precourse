package racingcar.car

class Car(val carName: String,
          private val moveStrategy: MoveStrategy = RandomMoveStrategy()) {
    init {
        require(carName.length < 6)
    }
    var position: String = ""

    fun drive(): String {
        if(moveStrategy.shouldMove()){
            position += "-"
        }
        return position
    }
}