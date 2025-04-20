package racingcar.gameflow

import racingcar.model.Car
data class GameInitResult(val cars: List<Car>, val rounds: Int)

/**
 *  [ Memo ]
 *  1. MutableList:
 *      Type of Change-able list
 *      (KOR) 변경 가능한 리스트 타입
 *
 *      mutableListOf(): Creates an empty mutable list
 *
 *  2. for-each loop:
 *      Iterates through each element of <nameList> and assigns it to the variable <name>.
 *      (KOR) nameList 리스트의 각 요소를 name 이라는 변수로 하나씩 꺼낸다.
 */
fun gameInit(input: GameConfig): GameInitResult {
    val nameList: List<String> = input.carNames.split(",")
    val carObjectList: MutableList<Car> = mutableListOf()
    for (name in nameList) {
        val tmpCar = Car(name.trim())
        carObjectList.add(tmpCar)
    }
    val nRounds = input.rounds.toInt()
    return GameInitResult(carObjectList, nRounds)
}