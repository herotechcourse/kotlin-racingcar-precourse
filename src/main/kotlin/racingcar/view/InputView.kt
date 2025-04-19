package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.error.RacingException.*

object InputView {

    fun readCars(): Cars {
        println("Enter the names of the cars (comma-separated):")

        val carNames = Console.readLine()
        checkIfCarNamesValid(carNames)
        val cars = Cars()
        carNames.split(",")
            .map { Car(it) }
            .forEach { cars.add(it) }
        return cars
    }

    fun readCount(): Int {
        println("How many rounds will be played?")

        val count = Console.readLine()
        checkIfCountValid(count)
        return count.toInt()
    }

    private fun checkIfCountValid(count: String) {
        isInputEmpty(count)
        if (!count.matches(Regex("^[1-9][0-9]*$"))) {
            throw IllegalArgumentException(WRONG_COUNT_ERROR.getDescription())
        }
    }

    private fun checkIfCarNamesValid(carNames: String) {
        isInputEmpty(carNames)
        isWrongFormat(carNames)
        isCarNameLengthValid(carNames)
        isCarNameDuplicate(carNames)
    }

    private fun isInputEmpty(input: String) {
        if (input.isEmpty()) {
            throw IllegalArgumentException(NO_INPUT_ERROR.getDescription())
        }
    }

    private fun isWrongFormat(carNames: String) {
        if (!carNames.matches(Regex("^(?!,)(?!.*,,)[a-zA-Z0-9,]+(?<! ,)$"))) {
            throw IllegalArgumentException(WRONG_FORMAT_ERROR.getDescription())
        }
    }

    private fun isCarNameLengthValid(carNames: String) {
        val names = carNames.split(",")
        for (name in names) {
            if (name.isEmpty() || name.length > 5) {
                throw IllegalArgumentException(CAR_NAME_LENGTH_ERROR.getDescription())
            }
        }
    }

    private fun isCarNameDuplicate(carNames: String) {
        val names = carNames.split(",")
        val set = mutableSetOf<String>()
        for (name in names) {
            if (!set.add(name)) {
                throw IllegalArgumentException(DUPLICATE_CAR_NAME_ERROR.getDescription())
            }
        }
    }
}