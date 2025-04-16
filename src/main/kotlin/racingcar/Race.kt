package racingcar

class Race(
    val rounds: Int,
    val cars: List<Car>,
) {
    fun run() {
       for(r in 1..rounds)
       {
            for(car in cars)
            {
                println("round: $r -> $car")
            }
        }
    }
}
