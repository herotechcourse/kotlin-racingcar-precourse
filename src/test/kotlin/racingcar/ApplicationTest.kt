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
    fun `exception test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `full scenario with 5 rounds and 3 cars - pobi, woni, jun`() {
        // 각 라운드마다 자동차 순서대로 랜덤값을 지정합니다
        // 예: [pobi1, woni1, jun1, pobi2, woni2, jun2, ...] 총 15개
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "5")
                val outputText = output()

                // 라운드 출력
                assertThat(outputText).contains(
                    "pobi : -",
                    "woni : ",
                    "jun : -",

                    "pobi : --",
                    "woni : -",
                    "jun : --",

                    "pobi : ---",
                    "woni : --",
                    "jun : ---",

                    "pobi : ----",
                    "woni : ---",
                    "jun : ----",

                    "pobi : -----",
                    "woni : ----",
                    "jun : -----"
                )

                // 최종 공동 우승자
                assertThat(outputText).contains("Winners : pobi, jun")
            },
            // 아래는 랜덤값 배열입니다
            // 순서: pobi, woni, jun × 5라운드 = 15개
            4, 3, 4, // 1R: pobi(+), woni(-), jun(+)
            4, 4, 4, // 2R: pobi(+), woni(+), jun(+)
            4, 4, 4, // 3R
            4, 4, 4, // 4R
            4, 4, 4  // 5R
        )
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
