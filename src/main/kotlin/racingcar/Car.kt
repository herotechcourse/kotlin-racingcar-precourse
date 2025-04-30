package racingcar

abstract class Vehicle {
    protected open lateinit var name : String
    protected open var position : Int = 0

    abstract fun goForward(distance: Int = 1)
    abstract fun getInfo() : String

    fun getName() : String = name
    fun getPosition() : Int = position

}

class Car(override var name: String, override var position: Int = 0) : Vehicle() {

    override fun goForward(distance: Int) {
        position += distance
    }

    override fun getInfo() : String{
        return "-".repeat(position)
    }

}
