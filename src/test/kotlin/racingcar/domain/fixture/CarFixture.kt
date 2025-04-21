package racingcar.domain.fixture

import racingcar.domain.Car
import racingcar.domain.Cars

class CarFixture() {
    private val numberFixture = Fixture()
    private val pobi: Car = Car("pobi", numberFixture.fourMovingNumberPicker())
    private val won: Car = Car("won", numberFixture.fiveMovingNumberPicker())

    fun toDomain(): Cars = Cars(mutableListOf(pobi, won))

    fun getPobi(): Car = pobi

    fun getWon(): Car = won
}