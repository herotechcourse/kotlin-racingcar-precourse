package racingcar
import camp.nextstep.edu.missionutils.Randoms

fun getRandomNumber() = Randoms.pickNumberInRange(0, 9)

fun runRace(cars: List<Car>, round: Int) {
    println("Race Results")
    repeat (round) {
        runRound(cars)
        println()
    }
}

fun runRound(cars: List<Car>) {
    cars.forEach { car ->
        car.moveIfPossible(getRandomNumber())
        println(car.render())
    }
}

fun findWinners(cars: List<Car>): List<Car> {
    val maxDistance = cars.maxOf { it.distance }
    return cars.filter { it.distance == maxDistance }
}


fun printWinners(cars: List<Car>) {
    val winners = findWinners(cars)
    println("Winners : ${winners.joinToString(", ") { it.name }}")
}