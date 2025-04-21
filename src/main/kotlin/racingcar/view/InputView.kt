package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
  fun readCarNames() : List<String> {
    println("Enter the names of the cars (comma-separated):")
    return Console.readLine().split(",")
  }

  fun readRounds() : Int {
    println("How many rounds will be played?")
    return Console.readLine().toInt()
  }
}