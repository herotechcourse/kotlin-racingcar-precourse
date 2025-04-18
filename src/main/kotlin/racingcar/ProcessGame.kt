package racingcar
import camp.nextstep.edu.missionutils.Randoms

fun initializeGame(nameList: List<String>): LinkedHashMap<String, Int> {
    return java.util.LinkedHashMap(nameList.associateWith { 0 })
}

fun processGame(gameProcess: HashMap<String, Int>) {
    gameProcess.forEach { (k, v) ->
        when {
            Randoms.pickNumberInRange(0, 9) >= 4 -> gameProcess[k] = v + 1
        }
    }
}