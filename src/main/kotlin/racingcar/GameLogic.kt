package racingcar
import camp.nextstep.edu.missionutils.Randoms

fun moveForward(): Boolean {
    val n: Int = Randoms.pickNumberInRange(0, 9)
    return n >= 4
}

fun getWinners(cars: MutableMap<String, String>): Map<String, String> {
    val highestPosition = cars.values.maxOfOrNull { it.length } ?: 0
    val winners = cars.filter { it.value.length == highestPosition }
    return winners
}

fun runRound(cars: MutableMap<String, String>) {
    for (car in cars) {
        if (moveForward()) {
            cars[car.key] = car.value + "-"
        }
        printRound(car)
    }
}