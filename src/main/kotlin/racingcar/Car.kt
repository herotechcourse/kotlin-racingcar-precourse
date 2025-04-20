package racingcar

class Car constructor(val name: String) {
    var distance: Int = 0

    fun moveForward(){
        distance += 1
    }
}