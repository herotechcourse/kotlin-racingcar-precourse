package racingcar.model

class Car(private val carName: CarName){
    private var position: Int=0

    fun move(random: Int){
        if(random>=4){
            position++
        }
    }

    fun name(): String = carName.toString()

    fun position(): Int = position

    fun isWinner(maxPosition: Int):Boolean {
        return position==maxPosition
    }
}