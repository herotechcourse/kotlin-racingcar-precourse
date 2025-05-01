package racingcar

abstract class Vehicle {
    //TODO 캡슐화로 setter X getter O 하기

    open lateinit var name : String
    open var position : Int = 0

    abstract fun move(distance: Int = 1)
    abstract fun positionLine() : String
    abstract fun getScore() : Int

    fun isMove(number : Int) : Boolean {
        return number >= 4
    }
}

class Car(override var name: String, override var position: Int = 0) : Vehicle() {

    override fun move(distance: Int) {
        position += distance
    }

    override fun positionLine() : String{
        return "-".repeat(position)
    }
    override fun getScore() : Int{
        return position
    }
}
