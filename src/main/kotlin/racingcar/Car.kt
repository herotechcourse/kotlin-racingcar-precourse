package racingcar

class Car(val name: String) {
    var position : Int = 0
    // Can't change outside of class
    private set

    // Moves if num is or bigger than 4.
    fun move(randomNum: Int){
        if(randomNum >= 4){
            position++
        }
    }

    // Prints results of 1 round
    fun status(): String {
        return "$name : ${"-".repeat(position)}";
    }
}