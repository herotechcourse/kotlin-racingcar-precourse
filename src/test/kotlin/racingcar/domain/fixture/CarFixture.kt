package racingcar.domain.fixture

import racingcar.domain.Car
import racingcar.domain.Cars

enum class CarFixture(val four: Car, val five: Car) {
    VALID_CARS(
        Car("pobi", Fixture.FourMovingNumberPicker),
        Car("won", Fixture.FiveMovingNumberPicker)
    );

    fun toDomain(): Cars = Cars(listOf(four, five))
}