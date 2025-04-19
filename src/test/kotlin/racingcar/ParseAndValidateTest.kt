package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
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

    override fun runMain() {
        main()
    }
}