package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: Implement the program
    val names = StringUtils.getUserName()
    val roundNumber = StringUtils.getRoundNumber()
    val generatedCars = StringUtils.generateCars(names)
    val race = Race(generatedCars,roundNumber)
    race.start()
}
