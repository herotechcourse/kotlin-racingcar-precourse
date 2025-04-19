package racingcar.domain

class car {
    var score = mutableMapOf<String, Int>();

    fun addScore(carName: String) : Unit {
        score.put(carName, score.getOrDefault(carName, 0) + 1);
    }
}