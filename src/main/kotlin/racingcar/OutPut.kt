package racingcar

/**
 * @packageName    : racingcar
 * @fileName       : OutPut
 * @author         : yong
 * @date           : 4/18/25
 * @description    :
 */
class Output {

    fun displayRaceResults(raceResultsMap: MutableMap<String, MutableList<String>>) {
        val rounds = raceResultsMap.values.first().size
        for(i in 0 until rounds) {
            for((car, roundResult) in raceResultsMap) {
                println("$car: ${roundResult[i]}")
            }
            println()
        }
    }

//    fun displayRaceResults(raceResult: String) {
//        println(raceResult)
//        println()
//    }

    fun displayWinners(winners: String) {
        println("Winners: ${winners}")
    }
}