package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Car

class InputView {
    fun receiveCarNamesInput(): List<Car> {
        println(MESSAGE_INPUT_CAR_NAMES)
        return Console.readLine().split(",").map { Car(it) }
    }

    fun receiveNumberOfRounds(): Int {
        println(MESSAGE_INPUT_NUMBER_OF_ROUNDS)
        return Console.readLine().toInt()
    }

    companion object {
        private const val MESSAGE_INPUT_CAR_NAMES = "Enter the names of the cars (comma-separated):"
        private const val MESSAGE_INPUT_NUMBER_OF_ROUNDS = "How many rounds will be played?"
    }
}
