package racingcar

class Car(val name: String) {

    var racePosition:Int = 0

    fun moveForward(randomnum: Int)
    {
        if (randomnum >= 4)
        {
            racePosition++
        }
    }
    fun formatProgress(): String
    {
        var movementBar: String = ""
        var carProgress: String
        for (i in 0 until racePosition)
        {
            movementBar = movementBar +"-"
        }
        carProgress = "$name : $movementBar"
        return carProgress
    }
}