package racingcar

class Car(val name: String) {
    var position : Int = 0
    // Can't change outside of class
    private set

    init {
        //Throws IllegalArgumentException if false
        require(name.isNotBlank() && name.length <= 5){
            "Car name must be non-blank and should not exceed 5 characters."
        }
    }

    // Moves if num is or bigger than 4.
    fun move(randomNum: Int){
        if(randomNum >= 4){
            position++
        }
    }

    // Prints results of 1 round
    fun status(): String {
        return "$name : ${"_".repeat(position)}";
    }
}