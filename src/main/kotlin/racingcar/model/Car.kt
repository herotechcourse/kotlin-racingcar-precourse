package racingcar.model

class Car(private val carName: CarName){
    private var position: Int=0

    fun move(random: Int){
        if(random>=Rules.MOVE_THRESHOLD){
            position++
        }
    }

    fun name(): String = carName.toString()

    fun position(): Int = position

    fun isWinner(maxPosition: Int):Boolean {
        return position==maxPosition
    }
}