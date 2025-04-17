package racingcar.model

import racingcar.strategy.MoveStrategy

class Car(private val carName: CarName){
    private var position: Int=0

    fun move(strategy: MoveStrategy){
        if(strategy.shouldMove()){
            position++
        }
    }

    fun name(): String = carName.toString()

    fun position(): Int = position

    fun isWinner(maxPosition: Int):Boolean {
        return position==maxPosition
    }
}