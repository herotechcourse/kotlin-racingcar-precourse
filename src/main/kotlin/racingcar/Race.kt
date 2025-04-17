package racingcar

class Race (val numOfRounds: Int) {
    val carsList:MutableList<Car> = mutableListOf()

    fun addCar(carName: Car) {
        carsList.add(carName)
    }

    fun constructCars(nameList: List<String>): List<Car> {
        return nameList.map { name -> Car(name.trim()) }
    }

    fun playRound() {
        carsList.forEach { car ->
            car.move()
            car.printRound()
        }
    }

    fun playRace() {
        val carNames = getInputCarNames()
        val cars = constructCars(carNames)
        val rounds = getInputNumRounds()
        repeat (rounds) {
            playRound()
        }
        val winners = findWinners()
        displayWinners(winners)
    }

    fun displayWinners(List<Car> winners) {
        print("Winners :")
        println(winners.joinToString(", ") { it.name })
    }

    fun findWinners(List<Car> cars): List<Car> {
        val maxSteps = cars.maxOf { it.steps }
        return (cars.filter { it.steps == maxSteps })
    }

}