package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.Car
import racingcar.domain.Race

fun main() {
    // 1. 자동차 이름을 입력받고, 유효성 검사를 실행
    println("자동차 이름을 입력하세요(쉼표로 구분):")
    val inputNames = Console.readLine()
    val names = inputNames.split(",").map { it.trim() }
    validateCarNames(names)

    // 2. 시도할 횟수를 입력받고, 유효성 검사를 실행
    println("시도할 횟수를 입력하세요:")
    val rounds = Console.readLine().toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해야 합니다")

    // 3. 자동차 객체 생성 및 Race 객체 생성
    val cars = names.map { Car(it) }
    val race = Race(cars, rounds)

    // 4. 경주 시작
    race.start()
}

// 자동차 이름 유효성 검사
fun validateCarNames(names: List<String>) {
    if (names.isEmpty()) throw IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.")
    if (names.any { it.length > 5 }) throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
}
