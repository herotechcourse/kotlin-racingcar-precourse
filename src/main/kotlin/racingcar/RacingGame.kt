package racingcar
import camp.nextstep.edu.missionutils.Randoms

class RacingGame(carNames: List<String>) {
    val cars = carNames.map {Car(it)}
    fun playRound(){
        cars.forEach { car ->
            val randomValue = Randoms.pickNumberInRange(0,9)
            car.move(randomValue)
        }
    }
    fun getWinners(): List<String>{
        val maxPos = cars.maxOf { it.position }
        return cars.filter { it.position == maxPos }
            .map { it.name }
    }
}