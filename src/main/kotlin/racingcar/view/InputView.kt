package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Car

class InputView {
    fun receiveCarNamesInput(): List<Car> {
        println("Enter the names of the cars (comma-separated):")
        return Console.readLine().split(",").map { Car(it) }
    }

    fun receiveNumberOfRounds(): Int {
        println("How many rounds will be played?")
        return Console.readLine().toInt()
    }
}
