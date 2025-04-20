package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Car

class InputView {
    fun readCarNames(): List<Car> {
        println(MESSAGE_READ_CAR_NAMES)
        return Console.readLine().split(DELIMITERS).map { Car(it) }
    }

    fun readNumberOfRounds(): Int {
        println(MESSAGE_READ_NUMBER_OF_ROUNDS)
        return Console.readLine().toInt()
    }

    companion object {
        private const val MESSAGE_READ_CAR_NAMES = "Enter the names of the cars (comma-separated):"
        private const val MESSAGE_READ_NUMBER_OF_ROUNDS = "How many rounds will be played?"
        private const val DELIMITERS = ","
    }
}
