package racingcar

class Race () {
    val carsList:MutableList<Car> = mutableListOf()

    fun addCar(carName: Car) {
        carsList.add(carName)
    }

    fun constructCars(nameList: List<String>) {
        nameList.forEach { name ->
            val newCar = Car(name.trim())
            addCar(newCar)
        }
    }

    fun playRound() {
        carsList.forEach { car ->
            car.move()
            car.printRound()
        }
    }

    fun playRace() {
        val carNames = getInputCarNames()
        constructCars(carNames)
        val rounds = getInputNumRounds()
        repeat (rounds) {
            playRound()
        }
        val winners = findWinners(carsList)
        displayWinners(winners)
    }

    fun displayWinners(winners: List<Car>) {
        print("Winners : ")
        println(winners.joinToString(", ") { it.name })
    }

    fun findWinners(cars: MutableList<Car>): List<Car> {
        val maxSteps = cars.maxOf { it.steps }
        return (cars.filter { it.steps == maxSteps })
    }

}