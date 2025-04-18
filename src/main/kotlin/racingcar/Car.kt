package racingcar

class Car(val carName: String) {
    private var position: Int = 0

    fun getName(): String {
        return this.carName
    }

    fun getPosition(): Int{
        return this.position
    }

    fun moveForward(randomNumber: Int) {
        if (randomNumber in 4..9){
            position+=1
        }
    }

    fun displayPosition() {
        println("$carName : ${"-".repeat(position)}")
    }
}
