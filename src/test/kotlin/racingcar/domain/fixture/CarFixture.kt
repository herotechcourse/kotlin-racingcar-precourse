package racingcar.domain.fixture

import racingcar.domain.Car
import racingcar.domain.Cars

class CarFixture() {
    private val numberPicker = CustomNumberPicker()
    private val pobi: Car = Car("pobi", numberPicker.fourMovingNumberPicker())
    private val won: Car = Car("won", numberPicker.fiveMovingNumberPicker())
    private val mina: Car = Car("mina", numberPicker.fiveMovingNumberPicker())

    fun toDomain(): Cars = Cars(mutableListOf(pobi, won, mina))

    fun getWon(): Car = won

    fun getMina(): Car = mina
}