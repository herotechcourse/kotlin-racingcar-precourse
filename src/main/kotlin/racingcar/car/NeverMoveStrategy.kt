package racingcar.car

class NeverMoveStrategy : MoveStrategy{
    override fun shouldMove(): Boolean {
        return false
    }
}