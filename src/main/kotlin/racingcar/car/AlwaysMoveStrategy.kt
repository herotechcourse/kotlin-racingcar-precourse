package racingcar.car

class AlwaysMoveStrategy : MoveStrategy {
    override fun shouldMove(): Boolean {
        return true
    }
}