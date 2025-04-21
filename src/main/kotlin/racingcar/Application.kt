package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    try {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNames = Console.readLine()
        
        println("시도할 회수는 몇회인가요?")
        val rounds = Console.readLine().toInt()
        
        carRacing(carNames, rounds)
    } catch (e: IllegalArgumentException) {
        println(e.message)
        throw e
    }
}

fun carRacing(names: String, rounds: Int) {
    // Validate inputs
    if (names.isEmpty() || rounds <= 0) {
        throw IllegalArgumentException("입력값이 유효하지 않습니다.")
    }
    
    val carNames = names.split(",").map { it.trim() }
    
    // Validate car names
    for (name in carNames) {
        if (name.isEmpty()) {
            throw IllegalArgumentException("입력값이 유효하지 않습니다.")
        }
        if (name.length > 5) {
            throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
        }
    }
    
    val positions = carNames.associateWith { 0 }.toMutableMap()
    
    println()
    println("실행 결과")
    
    // Simulate race
    for (i in 1..rounds) {
        // Move all cars for this round
        for (carName in carNames) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                positions[carName] = positions[carName]!! + 1
            }
        }
        
        // Print results once per round
        printResult(positions)
        println()
    }
    
    getWinner(positions)
}

fun printResult(positions: Map<String, Int>) {
    for ((carName, position) in positions) {
        println("$carName : ${"-".repeat(position)}")
    }
}

fun getWinner(positions: Map<String, Int>): String {
    val maxPosition = positions.values.maxOrNull() ?: 0
    val winners = positions.filter { it.value == maxPosition }.keys.toList()
    val winnerText = winners.joinToString(", ")
    
    println("Winners : $winnerText")
    return winnerText
}
