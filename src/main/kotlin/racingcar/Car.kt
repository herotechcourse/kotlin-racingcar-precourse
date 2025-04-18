package racingcar

data class Car(val name: String, var distance: Int = 0) {

    fun moveIfPossible(num: Int) {
        if (num >= 4) {
            distance += 1
        }
    }

}