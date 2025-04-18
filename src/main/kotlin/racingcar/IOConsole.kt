package racingcar

import camp.nextstep.edu.missionutils.Console

class IOConsole : IOInterface {
    override fun print(content: String) {
        println(content)
    }

    override fun read(): String {
        return Console.readLine()
    }
}
