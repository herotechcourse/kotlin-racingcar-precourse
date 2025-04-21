package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `should move the car when the condition is met`() {
        val car = Car("pobi")

        // 이동할 수 있는 조건을 설정 (예: 랜덤 번호가 4 이상)
        car.move { 4 >= 4 }

        // 위치가 1 증가했는지 확인
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `should not move the car when the condition is not met`() {
        val car = Car("pobi")

        // 이동할 수 없는 조건을 설정 (예: 랜덤 번호가 3 이하)
        car.move { 3 >= 4 }

        // 위치가 변경되지 않았는지 확인
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `should return the correct position display`() {
        val car = Car("pobi")
        car.move { 4 >= 4 } // 위치를 1로 증가시킨다.

        // 위치에 해당하는 '-' 문자가 반환되는지 확인
        assertThat(car.getPositionDisplay()).isEqualTo("-")
    }
}
