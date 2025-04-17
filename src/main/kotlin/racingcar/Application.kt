package racingcar
import racingcar.domain.Cars
import racingcar.view.InputCarNames
import racingcar.view.InputRoundCount


fun main() {
    val carNames = InputCarNames.invoke()
    val cars = Cars.from(carNames)

//    println("Entered car names: $carNames")
//    println("List of cars:")
//    cars.printAllCars()

    val roundCount = InputRoundCount.invoke()
//    println("Number of attempts: $trialCount")
}