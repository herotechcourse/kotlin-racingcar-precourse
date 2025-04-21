package racingcar

import racingcar.io.Input
import racingcar.io.Output
import racingcar.randomNumber.RandomNumberImpl

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val names: List<String> = Input().getNames(Input().input())

    println("How many rounds will be played?")
    val round: Int = Input().getRound(Input().input())

    val cars: List<Car> = names.map { Car(it) }
    val randomNumbers = List(round){RandomNumberImpl().generate(names.size)}
    val (raceResultMap, winners) = RacingService(cars, randomNumbers).play()

    Output(raceResultMap, winners)
}
