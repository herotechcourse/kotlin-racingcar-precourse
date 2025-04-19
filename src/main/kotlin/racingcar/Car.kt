package racingcar

class Car (private val name: String){

    private var _position: Int = 0

    val position: Int
        get() = _position

    val carName: String
        get() = name

    // Validation check in the init block to ensure the name is valid
    init {
        require(name.isNotBlank() && name.length <= 5) { "Car name may not be blank! \n Car name length should not be more than 5!" }
    }

    // Increases the car's position by 1 if the random number is >= 4
    fun move(randomNumber: Int) {
        if(randomNumber >=4){
            _position++
        }
    }

    // Returns a string representing the car's progress (visualizing the car's movement)
    fun getProgress(): String{
        return "$name : ${"-".repeat(position)}"
    }

}