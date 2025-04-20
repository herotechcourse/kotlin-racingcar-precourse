package racingcar.repository.exception;

class CarNotFoundException(name: String) : RuntimeException("Car '$name' does not exist in the storage")
