package racingcar.view

interface InputView {
    fun readCarName(): List<String>
    fun readRounds(): Int
}