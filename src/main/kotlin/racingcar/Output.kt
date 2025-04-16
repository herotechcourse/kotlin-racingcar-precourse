package racingcar

object Output {

    fun printGame(cars: List<Car>) {
        for(car in cars) {
            printPosition(car)
        }
        println()
    }

    fun printWinner(cars: List<Car>) {
        val winners = cars.joinToString(",") { car -> car.name }
        print("Winners : $winners")
    }

    private fun printPosition(car: Car) {
        print("${car.name}: ")
        repeat(car.position) {
            print("-")
        }
        println()
    }

}