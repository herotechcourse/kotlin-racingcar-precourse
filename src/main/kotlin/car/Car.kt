package car

private const val CAR_NAME_LIMIT = 5

class Car(carName: String) {
    init {
        require(carName.isNotBlank()) { "car names should not be empty or whitespaces" }
        require(carName.length <= CAR_NAME_LIMIT) { "car names cannot exceed 5 characters" }
    }

    val carName: String = carName;
    var progress: Int = 0
        private set
}


