package racingcar.model

class Car(val name: String) {
    var position: Int = 0
        private set
    
    fun move(number: Int) {
        if (number >= 4) {
            position++
        }
    }
}