package racingcar

class RoundInputCheck
{
    fun roundsFromInput(input: String): Int
    {
        if (!input.all {it.isDigit()})
            throw IllegalArgumentException("Only input digits, please")
        if (input.length < 1)
                throw IllegalArgumentException("Please input a number greater than 0")

        val numberOfRounds = input.toInt()

        if (!(numberOfRounds > 0))
            throw IllegalArgumentException("The number of rounds has to be at least 1") //maybe add an upper limit

        return (numberOfRounds)
    }

}