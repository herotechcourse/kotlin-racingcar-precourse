package racingcar

class Car(val name: String){
    var position = 0

    fun printStatus() {
        println("$name : ${"-".repeat(position)}")
    }
}