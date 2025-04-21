package racingcar.model

class Racing {
    private val END_GAME_COUNT = 0
    private var tryCount = 0
    fun saveTryCount(tryCount: Int) {
        this.tryCount = tryCount
    }

    fun minusTryCount() {
        tryCount--
    }

    val isProgress: Boolean
        get() = tryCount > END_GAME_COUNT
}
