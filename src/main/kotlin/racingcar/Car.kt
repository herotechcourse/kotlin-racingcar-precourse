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
}