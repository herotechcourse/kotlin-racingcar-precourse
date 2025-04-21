package racingcar.util

class InputValidator {
    fun validateCars(cars: List<String>?): Result<List<String>> {
        if (cars.isNullOrEmpty()) return Result.failure(IllegalArgumentException("Must provide a cars"))
        if (!cars.all { it.length <= 5 }) return Result.failure(
            IllegalArgumentException("Car name must be under 5 characters")
        )
        return Result.success(cars)
    }

    fun validateRounds(rounds: Int?): Result<Int> {
        if (rounds == null) return Result.failure(IllegalArgumentException("Must provide a number"))
        if (rounds < 0) return Result.failure(IllegalArgumentException("Round must be greater than 0"))
        return Result.success(rounds)
    }
}