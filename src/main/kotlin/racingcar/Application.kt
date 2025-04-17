package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val carList = readCars()
    val numberOfRounds =  readNumberOfRounds()
    RaceExecutor.execute(carList, numberOfRounds)
}

fun readCars(): List<Car>{
    print("Enter the names of the cars (comma-separated): ")
    val input = Console.readLine();
    return InputParser.parseCarNames(input)
}

fun readNumberOfRounds(): Int{
    print("How many rounds will be played?")
    val input = Console.readLine();

    return InputParser.parseNumberOfRounds(input)
}