package racingcar

interface Vihicle {
    fun goForward(distance: Int = 0)
    fun getName() : String
}

class Car : Vihicle {
    var position : Int = 0
    var name : String = ""
    fun Car(position : Int, name : String) {
        this.position = position
        this.name = name
    }

    override fun goForward(distance: Int) {
        position += distance
    }

    override fun getName() : String {
        return name
    }


}