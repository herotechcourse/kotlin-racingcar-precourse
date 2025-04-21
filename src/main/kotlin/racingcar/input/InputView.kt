package racingcar.input

interface InputView {
    fun readCarNames(): List<String>
    fun readRound(): String
}