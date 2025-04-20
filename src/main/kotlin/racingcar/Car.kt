package racingcar

class Car constructor(val name: String) {
    private var _distance: Int = 0
    val distance:Int
        get() = _distance

    fun moveForward(){
        _distance += 1
    }
}