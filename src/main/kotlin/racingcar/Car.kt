package racingcar

class Car (
    val name: String,
    var position: Int = 0
) {
    fun move(randomValue: Int){
        if (randomValue >= 4) {
            position++
        }
    }
}