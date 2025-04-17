package racingcar
import camp.nextstep.edu.missionutils.Randoms

fun moveForward(): Boolean {
    val n: Int = Randoms.pickNumberInRange(0, 9)
    return n >= 4
}

fun runRound(cars: MutableMap<String, String>) {
    for (car in cars) {
        if (moveForward()) {
            cars[car.key] = car.value + "-"
        }
    }
}
