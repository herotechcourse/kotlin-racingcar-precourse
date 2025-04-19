package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.ParseAndValidate.parseAndValidateNames
import racingcar.ParseAndValidate.parseAndValidateRounds

class ParseAndValidateTest : NsTest()  {
    @Test
    fun `exception test empty input`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { parseAndValidateNames("") }
        }
    }

    @Test
    fun `exception test blank input`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { parseAndValidateNames("        ") }
        }
    }

    @Test
    fun `exception test empty car name`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { parseAndValidateNames("mimi,,nana") }
        }
    }

    @Test
    fun `exception test negative number`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { parseAndValidateRounds("-1") }
        }
    }

    @Test
    fun `exception test 0 number`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { parseAndValidateRounds("0") }
        }
    }

    @Test
    fun `exception test empty number input`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { parseAndValidateRounds("") }
        }
    }

    @Test
    fun `exception test blank number input`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { parseAndValidateRounds("       ") }
        }
    }

    @Test
    fun `parsing test two car names`() {
        assertSimpleTest {
            val names = parseAndValidateNames("mimi,nana")
            assertThat(names.containsAll(listOf("mimi", "nana")))
        }
    }

    @Test
    fun `parsing test one car names`() {
        assertSimpleTest {
            val names = parseAndValidateNames("mimi")
            assertThat(names.containsAll(listOf("mimi")))
        }
    }

    @Test
    fun `parsing test rounds`() {
        assertSimpleTest {
            val rounds = parseAndValidateRounds("5")
            assertThat(rounds == 5)
        }
    }

    override fun runMain() {
        main()
    }
}