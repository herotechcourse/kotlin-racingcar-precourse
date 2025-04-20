package racingcar.repository.exception;

class DuplicateCarException(name: String) : RuntimeException("Car '$name' already exists in the storage")
