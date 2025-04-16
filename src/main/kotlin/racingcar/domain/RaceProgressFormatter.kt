package racingcar.domain

class RaceProgressFormatter {
    fun format(cars: Cars): List<String> {
        return cars.all().map { car ->
            "${car.name()} : ${"-".repeat(car.position())}"
        }
    }
}