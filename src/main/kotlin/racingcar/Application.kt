package racingcar
import camp.nextstep.edu.missionutils.Console

fun main() {
    val names = getNamesInput()
    val gameLength = getGameLengthInput()

    val game = RaceGame(names, gameLength)
    game.startGame()
    game.printWinner()
}

fun getNamesInput() : List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val names = Console.readLine()

    val namesArray = names.split(",")
    namesArray.ifEmpty { throw IllegalArgumentException("잘못된 입력입니다.") }

    for (name in namesArray) {
        if(name.length > 5) {
            throw IllegalArgumentException("잘못된 입력입니다.")
        }
    }

    return namesArray
}

fun getGameLengthInput() : Int {
    println("시도할 회수는 몇 회인가요?")
    val gameLength= Console.readLine()

    return try {
        gameLength.toInt()
    } catch (e: Exception) {
        throw IllegalArgumentException("잘못된 입력입니다.")
    }
}
