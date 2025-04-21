package racingcar.domain

class Car {
    var score = mutableMapOf<String, Int>();

    fun addScore(carName: String): Unit {
        score[carName] = score.getOrDefault(carName, 0) + 1;
    }

    fun getScore(carName: String): Int {
        return score.getOrDefault(carName, 0)
    }
}