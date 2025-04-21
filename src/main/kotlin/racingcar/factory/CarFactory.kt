package racingcar.factory

import racingcar.domain.Car

/**
 * Factory responsible for creating Car instances from validated names.
 */
object CarFactory {
	fun fromNames(names: List<String>): List<Car> {
		return names.map { Car(it) }
	}
}