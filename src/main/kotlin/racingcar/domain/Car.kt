package racingcar.domain

/**
 * 자동차를 나타내는 클래스입니다.
 *
 * @property name 자동차의 이름 (최대 5자)
 * @property position 자동차의 현재 위치
 */
class Car(val name: String, var position: Int = 0) {

    /**
     * 주어진 조건에 따라 자동차를 전진시킵니다.
     *
     * @param canMove 자동차가 전진할 수 있는 조건을 나타내는 함수
     */
    fun move(canMove: () -> Boolean) {
        if (canMove()) {
            position++
        }
    }

    /**
     * 자동차의 현재 위치를 문자열로 반환합니다.
     *
     * @return 자동차의 위치를 '-' 문자의 반복으로 표현한 문자열
     */
    fun getPositionDisplay(): String {
        return "-".repeat(position)
    }
}