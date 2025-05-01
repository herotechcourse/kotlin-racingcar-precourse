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

    val namesArray = names
        .split(",")
        .map{ it.trim() }
        .filter{ it.isNotEmpty() }
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
        val number =  gameLength.toInt()
        if (number <= 0) {
            throw IllegalArgumentException("1 이상의 값을 입력해 주세요.")
        }
        number
    } catch (e: Exception) {
        throw IllegalArgumentException("잘못된 입력입니다.")
    }
}
