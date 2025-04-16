package racingcar

class Car(name: String) {
    init {
        fun isValidNameLength(nameLength : Int) : Boolean = nameLength <= 5

        require(isValidNameLength(name.length)) {
            "Car name cannot exceed 5 characters, current name length: ${name.length} "
        }
    }
}
