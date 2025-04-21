package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("자동차 이름 입력: ")
    val carNames = Console.readLine().split(",").map { it.trim() }

    if (carNames.any { it.length > 5 }) {
        throw IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.")
    }

    println("경기 라운드 수 입력: ")
    val rounds = Console.readLine().toIntOrNull() ?: throw IllegalArgumentException("라운드 수를 입력해주세요.")

    val cars = carNames.map { Car(it) }
    val game = RacingGame(cars)

    println("\n경기 결과")
    repeat(rounds) {
        game.playRound()
        ResultView.printRaceStatus(cars)  // ✅ 핵심 포인트
    }

    val winners = game.getWinners()
    ResultView.printWinners(winners)     // ✅ 우승자 출력도 따로
}
