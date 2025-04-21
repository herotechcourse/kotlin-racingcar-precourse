package racingcar.output

class RaceResultRenderer {

    fun calculatePerRoundScores(raceResult: Map<String, List<Int>>, rounds: Int): List<Map<String, Int>> {
        val resultsPerRound = mutableListOf<Map<String, Int>>()

        for (i in 1..rounds) {
            val roundScores = raceResult.mapValues { (_, scores) ->
                scores.take(i).count { it >= 4 }
            }
            resultsPerRound.add(roundScores)
        }

        return resultsPerRound
    }

    fun calculateRaceScores(raceResult: Map<String, List<Int>>, rounds: Int): Map<String, Int> {
        return raceResult.mapValues { (_, scores) ->
            scores.take(rounds).count { it >= 4 }
        }
    }

    fun determineWinners(finalResults: Map<String, Int>): List<String> {
        val max = finalResults.values.maxOrNull() ?: return emptyList()
        return finalResults.filter { it.value == max }.keys.toList()
    }

    fun renderPerRoundScores(perRoundScores: List<Map<String, Int>>): String {
        return perRoundScores.joinToString("\n\n") { scores ->
            scores.entries.joinToString("\n") { (car, score) ->
                "$car : ${"-".repeat(score)}"
            }
        }
    }

    fun renderFinalWinners(winners: List<String>): String {
        return "\nWinners : ${winners.joinToString(",")}"
    }

}




