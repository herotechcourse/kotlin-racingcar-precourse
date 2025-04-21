package racingcar.domain

class Car {
    var score = mutableMapOf<String, Int>();

    fun addScore(carName: String): Unit {
        score[carName] = score.getOrDefault(carName, 0) + 1;
    }

    fun getScore(carName: String): Int {
        if (score[carName] == null) {
            return 0;
        }
        return score[carName]!!;
    }
}