package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


fun main()
{
    val carNames = readInputNames()
    val numOfRounds = readInputRounds()
    val carObjects = createCarObjects(carNames)

    manageRace(carObjects, numOfRounds)

    var winners = determineWinner(carObjects)
    printWinner(winners)
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

fun generateRandomNumber(): Int
{
    var num = Randoms.pickNumberInRange(0,9)
    return num
}

fun manageRace(cars: List<Car>, numOfRounds: Int)
{
    printRaceResultHeading()
    var roundsLeft = numOfRounds
    while (roundsLeft > 0)
    {
        move(cars)
        printRoundProgress(cars,numOfRounds)
        roundsLeft--
    }
}

fun move(cars: List<Car>)
{
    for (car in cars)
    {
        var moveNumber = generateRandomNumber()
        car.moveForward(moveNumber)
    }
}
fun printRaceResultHeading()
{
    println("Race Results")
}

fun printRoundProgress(cars: List<Car>, numOfRounds: Int)
{
    for (car in cars)
    {
        var movementBar = car.formatProgress()
        println(movementBar)
    }
    println()
}

fun determineWinner(cars: List<Car>): List<String>
{
    var maxScore: Int = 0
    for (car in cars)
    {
        if (car.racePosition > maxScore)
        {
            maxScore = car.racePosition
        }
    }
    var winners = mutableListOf<String>()
    for (car in cars)
    {
        if (car.racePosition == maxScore)
        {
            winners.add(car.name)
        }
    }
    return winners
}

fun printWinner(winners: List<String>)
{
    println("Winners : ${winners.joinToString(", ")}")
}




