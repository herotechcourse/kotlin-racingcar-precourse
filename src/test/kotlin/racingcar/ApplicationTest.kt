package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `feature test`() {
        // 기본적인 기능 테스트 (정상 동작 여부)
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "Winners : pobi")
            },
            MOVING_FORWARD,
            STOP,
        )
    }

    @Test
    fun `name length validation test`() {
        // 이름이 5자를 초과하는 경우 예외 발생 확인
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("a,bb,ccc,dddd,eeeee,ffffff", "1") }
        }
    }

    @Test
    fun `invalid round input test`() {
        // 라운드 입력값이 잘못되었을 때 예외 처리
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "-1") }
        }

        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "abc") }
        }
    }

    @Test
    fun `multiple winners test`() {
        // 공동 우승자 출력 확인
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("Winners : pobi, woni")
            },
            MOVING_FORWARD,
            MOVING_FORWARD,
        )
    }

    @Test
    fun `car position string test`() {
        // positionToString() 출력값 확인
        val car = Car("test")
        car.distance = 0
        assertThat(car.positionToString()).isEqualTo("")

        car.distance = 3
        assertThat(car.positionToString()).isEqualTo("---")
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
