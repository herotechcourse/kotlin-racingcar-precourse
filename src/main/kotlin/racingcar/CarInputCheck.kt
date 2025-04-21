package racingcar

class CarInputCheck
{
    fun carsFromInput(input: String): List<String>
    {
        var i = -1

        val carsInRace = mutableListOf<String>()
        var newCar = StringBuilder()

        while (++i < input.length)
        {
            if (input[i] == ',')
                continue

            newCar.append(input[i])
            if (newCar.length > 5)
                throw IllegalArgumentException("Car names should not exceed 5 characters")

            if (i + 1 ==input.length || (i + 1 < input.length && input[i + 1] == ','))
            {
                if (newCar.toString() in carsInRace)
                    throw IllegalArgumentException("Each car should have a unique name")
                carsInRace.add(newCar.toString())
                newCar = StringBuilder()
            }
        }
        if (carsInRace.isEmpty())
            throw IllegalArgumentException("At least one car should participate in the race")
        return carsInRace
    }

}