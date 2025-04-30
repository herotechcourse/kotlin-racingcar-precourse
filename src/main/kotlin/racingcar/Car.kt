package racingcar

interface Vihicle {
    fun goForward(distance: Int = 1)
    fun getname()
    fun printInfo()
}
class Car(var position: Int = 0, var name: String) : Vihicle {
    companion object{

    }

    override fun goForward(distance: Int) {
        position += distance
    }

    override fun getname() {
        print(name)
    }

    override fun printInfo() {
        val positionBar = "-".repeat(position)
        println("$name : $positionBar")
    }

}