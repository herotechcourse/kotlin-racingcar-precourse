package racingcar
import camp.nextstep.edu.missionutils.Randoms

fun moveCars(cars: MutableMap<String, String>, car: MutableMap.MutableEntry<String, String>, n: Int) {
    if (n >= 4) {
        cars[car.key] = car.value + "-"
    }
}

fun runRound(cars: MutableMap<String, String>) {
    for (car in cars) {
        moveCars(cars, car, Randoms.pickNumberInRange(0, 9))
        printRound(car)
    }
    println()
}

fun getWinners(cars: MutableMap<String, String>): Map<String, String> {
    val highestPosition = cars.values.maxOfOrNull { it.length } ?: 0
    val winners = cars.filter { it.value.length == highestPosition }
    return winners
}

fun game(cars: MutableMap<String, String>, rounds: Int) {
    var i = 0
    println("Race Results")
    while (i < rounds) {
        runRound(cars)
        i++
    }
    printWinners(cars)
}