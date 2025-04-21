package racingcar
import camp.nextstep.edu.missionutils.Randoms

class RaceDriver(private val cars: List<String>, private val totalRounds: Int)
{
    fun run()
    {
        val distancesTravelled = MutableList(cars.size) { "" }

        println("\nRace Results")
        for (i in 1..totalRounds)
        {
            driveRound(distancesTravelled)
            illustrateRound(cars, distancesTravelled)
        }
        println(declareWinner(cars, distancesTravelled))
    }

    fun driveRound(distancesTravelled: MutableList<String>)
    {
        for (i in distancesTravelled.indices)
        {
            if (Randoms.pickNumberInRange(0, 9) >= 4)
            {
                distancesTravelled[i] += "-"
            }
        }
    }

    fun illustrateRound(cars: List<String>, distancesTravelled: List<String>)
    {
        for (i in cars.indices)
        {
            val carProgress = cars[i] + " : " + distancesTravelled[i]
            println(carProgress)
        }
        println()
    }

    fun declareWinner(cars: List<String>, distancesTravelled: List<String>) : String
    {
        var longestDistanceCrossed = 0
        var winners = mutableListOf<String>()

        for (i in distancesTravelled.indices)
        {
            val distance = distancesTravelled[i].length

            if (distance > longestDistanceCrossed)
            {
                longestDistanceCrossed = distance
                winners = mutableListOf(cars[i])
            }
            else if (distance == longestDistanceCrossed)
            {
                winners.add(cars[i])
            }
        }

        /*val result = if (winners.size > 1)
            "Winners: ${winners.joinToString(", ")}"
        else
            "Winner: ${winners[0]}"*/

        val result = "Winners : ${winners.joinToString(", ")}"
        return result
    }
}

