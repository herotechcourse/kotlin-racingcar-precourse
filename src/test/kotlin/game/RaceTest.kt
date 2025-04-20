package game

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.main

class RaceTest : NsTest() {

    @Test
    fun `dont allow single car names`() {
        assertSimpleTest {
            // single car name
            assertThrows<IllegalArgumentException> { runException("pobi", "1") }
        }
    }

    @Test
    fun `dont allow total rounds to be less than 1`() {
        assertSimpleTest {
            // test total round not less than 1
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "0") }
            assertThrows<IllegalArgumentException> { runException("pobi,woni", " ") }
        }
    }

    override fun runMain() {
        main()
    }

}