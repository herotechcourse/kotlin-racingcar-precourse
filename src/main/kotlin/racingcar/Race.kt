package racingcar
import camp.nextstep.edu.missionutils.Randoms

class Race(private val cars: List<Car>, private val rounds: Int)  {

    // Function to start the race
    fun startRace(){
        repeat(rounds) {
                println("Round ${it + 1}")
                cars.forEach { car ->
                    val random = Randoms.pickNumberInRange(0, 9)
                    car.move(random)
                    println(car.getProgress())
                }
                println()
        }
    }

    // Function to determine the winner
    fun printWinners() {
        val max = cars.maxOf { it.position }
        val winners = cars.filter { it.position == max }
        println("Winners : ${winners.joinToString(", ") { it.carName }}")
    }
}

