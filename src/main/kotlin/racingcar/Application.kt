package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String){
    var distance: Int = 0       //

    fun moveByRandom() {
        val number = Randoms.pickNumberInRange(0,9) // 0~9
        if (number >= 4) distance++
    }

    fun positionToString(): String = "-".repeat(distance)
}

class CarRacingGame {
    fun start() {   // 시작부
        val cars = inputCarNames()   // 이름들 입력부. 이름들 리스트 반환받음
        val rounds = inputRounds()   //

        repeat(rounds) {
            cars.forEach { it.moveByRandom() }   // 각 자동차마다 랜덤값 받고 기준값에 따라 한 칸 씩 이동
            cars.forEach { println("${it.name} : ${it.positionToString()}") }   // 해당 턴에서의 각 자동차 거리 출력
            println()
        }

        val max = cars.maxOf { it.distance }
        val winners = cars.filter { it.distance == max }
        println("Winners : ${winners.joinToString(", ") { it.name }}")
    }

    private fun inputCarNames(): List<Car> {     // 차 이름 입력부
        print("Enter the names of the cars (comma-separated):\n")
        val input = readln()
        val names = input.split(',')
//        println(names)

//        if (names.any { it.length > 5 }) {
//            throw IllegalArgumentException("Car names must be up to 5 characters.")
//        }

        if (names.any { it.isEmpty() || it.length > 5 }) {
            throw IllegalArgumentException("Car names must be non-empty and up to 5 characters.")
        }

        return names.map { Car(it) }
    }

    private fun inputRounds(): Int {     // 라운드 수 입력부
        print("How many rounds will be played?\n")
        val input = readln()

        val numInput: Int = input.toIntOrNull() ?: -1   //
        if(numInput < 0) {
            throw IllegalArgumentException("Number of rounds must be a positive integer.")
        }
        else{
            return numInput
        }
    }

}


fun main() {
    // TODO: Implement the program

    val game=CarRacingGame()
    game.start()

}
