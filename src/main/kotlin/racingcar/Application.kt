package racingcar

import camp.nextstep.edu.missionutils.Console

fun main()
{
    val firstInputCheck = CarInputCheck()
    val cars = firstInputCheck.carsFromInput(Console.readLine())

    val secondInputCheck = RoundInputCheck()
    val numberOfRounds = secondInputCheck.roundsFromInput(Console.readLine())

    val race = RaceDriver(cars, numberOfRounds)
    race.run()

}
