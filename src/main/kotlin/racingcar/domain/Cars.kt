package racingcar.domain

class Cars(val cars: List<Car>) {
    companion object {
        fun from(names: List<String>): Cars {
            val carList = names.map { Car(it) }
            return Cars(carList)
        }
    }
}