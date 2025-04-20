package car

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.main

class CarTest: NsTest() {
    @Test
    fun `dont allow empty or whitespace car names`() {
        assertSimpleTest {
            // empty car name
            assertThrows<IllegalArgumentException> { runException("pobi,,java", "1") }
            assertThrows<IllegalArgumentException> { runException("pobi, ", "1") }
        }
    }

    fun `dont allow car names more than 5 characters`() {
        assertSimpleTest {
            // car names exceed 5 characters
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    override fun runMain() {
        main()
    }
}