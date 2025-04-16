package racingcar

object Output {

    fun printGame(cars: List<Car>) {
        for(car in cars) {
            printPosition(car)
        }
        println()
    }

    private fun printPosition(car: Car) {
        print("${car.name}: ")
        repeat(car.position) {
            print("-")
        }
        println()
    }

}