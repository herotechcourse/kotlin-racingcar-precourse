package racingcar.services

import camp.nextstep.edu.missionutils.Randoms

fun executeRace(cars: List<String>, rounds: Int): MutableMap<String, Int> {
    val results = cars.associateWith { 0 }.toMutableMap()
    repeat(rounds) {
        for (car in cars) {
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            results[car] = results[car]!! + 1
            if (randomNumber >= 4) {
                results[car] = results[car]!! + 1
            }
        }
    }
    return results
}