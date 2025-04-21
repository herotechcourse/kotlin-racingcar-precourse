package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

/**
 * 자동차 경주를 관리하는 클래스입니다.
 *
 * @property cars 경주에 참여하는 자동차들의 리스트
 * @property rounds 경주의 총 라운드 수
 */
class Race(private val cars: List<Car>, private val rounds: Int) {

    /**
     * 경주를 시작하고 결과를 출력합니다.
     */
    fun start() {
        println("Race Results")
        repeat(rounds) {
            playRound()
            printStatus()
        }
        val winners = getWinners().joinToString(", ") { it.name }
        println("Winners : $winners")
    }

    /**
     * 한 라운드를 진행하고 자동차들의 전진 여부를 결정합니다.
     */
    private fun playRound() {
        cars.forEach { car ->
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            car.move { randomNumber >= 4 }
        }
    }

    /**
     * 자동차들의 현재 위치를 출력합니다.
     */
    private fun printStatus() {
        cars.forEach { car ->
            println("${car.name} : ${car.getPositionDisplay()}")
        }
        println() // 각 라운드 후 한 줄 띄우기
    }

    /**
     * 경주에서 우승한 자동차(들)를 반환합니다.
     */
    fun getWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }
}
