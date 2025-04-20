package racingcar

class Cars(private val list: List<Car>) {
    fun moveAll(randomValue: () -> Int) {
        list.forEach { it.move(randomValue) }
    }
    fun findWinners(): List<String> {
        val maxPos = list.maxOf { it.position }
        return list.filter { it.position == maxPos }
                   .map { it.name }
    }
    fun getCars(): List<Car> = list
}
