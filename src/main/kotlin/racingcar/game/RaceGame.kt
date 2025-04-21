package racingcar.game

class RaceGame<T> {
    fun playRound(conditionCb: (T) -> Boolean, cb: (T) -> T): (List<T>) -> List<T> = { entry ->
        entry.map { if (conditionCb(it)) cb(it) else it }
    }

    fun simulateRounds(): (Int, List<T>, (List<T>) -> List<T>) -> List<List<T>> = { rounds, entry, cb ->
        (1..rounds).fold(listOf(entry)) { acc, _ -> acc + listOf(cb(acc.last())) }.drop(1)
    }

    fun findWinners(): (List<T>, (T) -> Int) -> List<T> = { list, cb ->
        list.filter { cb(it) == list.maxOfOrNull(cb) }
    }
}
