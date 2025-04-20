package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.service.CarService
import racingcar.util.Input
import racingcar.util.Output

class Racing (
    private var max: Int = 0,
    private val input: Input = Input(),
    private val output: Output = Output(),
    private val carService: CarService = CarService()
) {
    fun start() {
        val carNames = input.getCarNames();
        val roundCount = input.getRoundCount();
        generateResults(carNames, roundCount);
        generateWinners(carNames);
    }

    fun generateResults(carNames: List<String>, roundCount: Int) {
        output.printResultPhrase();
        for (round in 1..roundCount) {
            makeRoundResult(carNames);
        }
    }

    fun makeRoundResult(carNames: List<String>) {
        val results = carNames.map { carName ->
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (carService.canIncreaseScore(randomNumber, carName)) {
                carService.updateScore(carName)
            }
            val score = carService.retrieveScore(carName)
            if (isNewMaxScore(score)) {
                max = score
            }
            "$carName : ${"-".repeat(score)}"
        }
        output.printRoundResult(results)
    }

    fun isNewMaxScore(score: Int) : Boolean{
        return max < score;
    }

    fun generateWinners(carNames: List<String>) {
        val winners = findWinners(carNames);
        output.printWinners(winners);
    }

    fun findWinners(carNames: List<String>) : List<String>{
        val winners = carNames.filter { name ->
            carService.retrieveScore(name) == max
        }
        return winners;
    }
}
