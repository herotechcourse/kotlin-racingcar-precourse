package racingcar.car

class Car(val carName: String) {
    init {
        require(carName.length < 5)
    }
    //drive code
}