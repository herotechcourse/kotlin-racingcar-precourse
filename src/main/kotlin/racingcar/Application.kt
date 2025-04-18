package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


fun main()
{
    var carNames = readInputNames()
    val numOfRounds = readInputRounds()
    val carObjects = createCarObjects(carNames)
    testPrintInput(carObjects)


}

fun readInputNames (): List<String>
{
    println("Enter the name of the car(comma-separated):")
    var input = Console.readLine()
    var nameList = input.replace(" ","")
    var names = nameList.split(",")

    for (name in names)
    {
        if (name.isEmpty())
        {
            throw IllegalArgumentException("Car name cannot be empty")
        }
        if (name.length > 5)
        {
            throw IllegalArgumentException("Car name cannot exceed 5 characters")
        }
    }
    return names
}

fun readInputRounds(): Int
{
    println("How many rounds will be played?")
    var numOfRounds = Console.readLine().toInt()
    if (numOfRounds == 0)
    {
        throw IllegalArgumentException("Number of rounds must be greater than zero")
    }
    return numOfRounds
}

fun createCarObjects(names: List<String>): List<Car>
{
    val cars = mutableListOf<Car>()
    for (name in names)
    {
        cars.add(Car(name))
    }
    return cars
}

fun testPrintInput(cars: List<Car>)
{
    for (car in cars)
    {
        println(car.name)
        println(car.raceposition)
    }
}

