package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.app.CarRaceApp

fun main() = CarRaceApp(moveThreshold = 4) { Randoms.pickNumberInRange(0, 9) }.play()
