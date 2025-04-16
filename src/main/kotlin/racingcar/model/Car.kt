package racingcar.model

class Car(val name: String, private var status: Int = 0) {

    fun go() {
        // if fuel is enough
        this.status++;
    }

    fun getStatus() = status
}
