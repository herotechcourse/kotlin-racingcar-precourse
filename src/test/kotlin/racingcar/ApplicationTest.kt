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
    fun `empty name input test`()
    {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { run("    ,car2", "1") } }
    }

    @Test
    fun `accepting and trimming spaces in name input test`()
    {
        run("   car1, car2  ", "1")
        assertThat(output()).contains("car1", "car2")
    }

    @Test
    fun `input round is zero test`()
    {
        assertSimpleTest { assertThrows<IllegalArgumentException> { run("car1,car2", "0") } }
    }

    @Test
    fun `input round is non-numeric test`()
    {
        assertSimpleTest { assertThrows<IllegalArgumentException> { run("car1,car2", "two") } }
    }

    @Test
    fun `initialization of car objects from user input`()
    {
        run ("car1, car2, car3", "1")
        assertThat(output()).contains("car1", "car2", "car3")
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
