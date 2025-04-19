package racingcar.domain

class Car {
    var score = mutableMapOf<String, Int>();

    fun addScore(carName: String) : Unit {
        score.put(carName, score.getOrDefault(carName, 0) + 1);
    }
}