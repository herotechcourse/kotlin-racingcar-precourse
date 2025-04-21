package racingcar.model

class RacingCars private constructor(
    private val cars: List<RacingCar>
) {

    companion object {
        fun fromNames(names: List<String>): RacingCars {
            val cars = names.map { RacingCar(it) }
            return RacingCars(cars)
        }
    }

    fun all(): List<RacingCar> = cars
}
