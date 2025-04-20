package racingcar.controller
import racingcar.domain.Car
import racingcar.view.InputView
import racingcar.view.OutputView

object GameController {
    fun runRacing(){
        val carNames = InputView.inputCarNames()
        val round = InputView.inputRoundNum()
        val cars = carNames.map{ Car(it)}

        OutputView.printRaceResults()
        repeat(round){
            cars.forEach {it.move()}
            OutputView.printPosition(cars)
    }
        val maxPosition = cars.maxOf {it.position}
        val winners = cars.filter{ it.position == maxPosition}.map{it.name}
        OutputView.printWinners(winners)

    }
}