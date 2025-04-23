package racingcar.domain

class Car(val name: String, var position: Int = 0) {

    fun move(randomNumber: Int){
            if(randomNumber >= 4) {
                position++
        }
    }
}