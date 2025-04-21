package racingcar.process

import camp.nextstep.edu.missionutils.Randoms

class RaceExecutor {
    fun executeRaceAndGetResult(carNames : List<String>, rounds: Int): Map<String, List<Int>>{
        val raceResult = mutableMapOf<String, MutableList<Int>>()
        carNames.forEach{ name -> raceResult[name] = mutableListOf() }
        repeat(rounds){
            raceResult.forEach { (_,list) ->
                list.add(Randoms.pickNumberInRange(0,9))
            }
        }
        return raceResult
    }
}