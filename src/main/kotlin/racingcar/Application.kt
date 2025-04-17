package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


fun main()
{
    var numofrounds: Int = 0

    println("Enter the name of the car(comma-separated):")
    var inputname = Console.readLine()
    var namelist = inputname.replace(" ","")
    var names = namelist.split(",")

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
        else
        {
            //println(name)
        }
    }
    println("How many rounds will be played?")
    numofrounds = Console.readLine().toInt()
    if (numofrounds == 0)
    {
        throw IllegalArgumentException("Number of rounds must be greater than zero")
    }

    //println(names)
    //println(numofrounds)
}

