package racingcar.formatter

import racingcar.domain.Cars

class RaceProgressFormatter {
    fun format(cars: Cars): List<String> {
        return cars.formatEachCarWith { name, position ->
            "$name : ${"-".repeat(position)}"
        }
    }
}