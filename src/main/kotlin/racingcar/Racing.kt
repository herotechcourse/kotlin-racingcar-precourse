package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.service.CarService
import racingcar.util.*


class Racing(
    private var max: Int = 0,
    private val carService: CarService = CarService()
) {
    fun start() {
        val carNames = getCarNames();
        val roundCount = getRoundCount();
        generateResults(carNames, roundCount);
        generateWinners(carNames);
    }

    fun generateResults(carNames: List<String>, roundCount: Int) {
        printResultPhrase();
        for (round in 1..roundCount) {
            makeRoundResult(carNames);
        }
    }

    fun makeRoundResult(carNames: List<String>) {
        val results = carNames.map { carName ->
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            checkRandomNumber(randomNumber, carName);

            val score = carService.retrieveScore(carName)
            compareScoreAndMax(score);
            "$carName : ${"-".repeat(score)}"
        }
        printRoundResult(results)
    }

    fun checkRandomNumber(randomNumber: Int, carName: String) {
        if (carService.canIncreaseScore(randomNumber, carName)) {
            carService.updateScore(carName)
        }
    }

    fun compareScoreAndMax(score: Int) {
        if (isNewMaxScore(score)) {
            max = score
        }
    }

    fun isNewMaxScore(score: Int): Boolean {
        return max < score;
    }

    fun generateWinners(carNames: List<String>) {
        val winners = findWinners(carNames);
        printWinners(winners);
    }

    fun findWinners(carNames: List<String>): List<String> {
        val winners = carNames.filter { name ->
            carService.retrieveScore(name) == max
        }
        return winners;
    }
}
