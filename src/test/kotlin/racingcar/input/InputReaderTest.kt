import camp.nextstep.edu.missionutils.Console
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.input.InputReader
import java.io.ByteArrayInputStream

class InputReaderTest {

    private lateinit var inputReader :InputReader

    @BeforeEach
    fun setUp(){
        inputReader = InputReader()
    }

    @AfterEach
    fun tearDown() {
        Console.close()
    }

    @Test
    fun `should return names of cars from console input`() {
        val input = "pobi,woni\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val result = inputReader.readAndGetCarNames()

        assertThat(result).containsExactly("pobi", "woni")
    }

    @Test
    fun `should trim spaces from car names`() {
        val input = "pobi , woni\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val result = inputReader.readAndGetCarNames()

        assertThat(result).containsExactly("pobi", "woni")
    }

    @Test
    fun `should throw exception when carName exceeds five characters`() {
        val input = "pobi,javaji\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        assertThatThrownBy {
            inputReader.readAndGetCarNames()
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("CarName exceeds 5 characters")
    }

    @Test
    fun `should throw exception when carName is empty`() {
        val input = "\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        assertThatThrownBy {
            inputReader.readAndGetCarNames()
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car names must not be empty")
    }

    @Test
    fun `should throw exception when car names are not unique`() {
        val input = "pobi,pobi\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        assertThatThrownBy {
            inputReader.readAndGetCarNames()
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car names must be unique")
    }

    @Test
    fun `should return number of rounds from console input`() {
        val input = "7\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val result = inputReader.readAndGetRounds()

        assertThat(result).isEqualTo(7)
    }

    @Test
    fun `should throw exception when roundNumber is empty`() {
        val input = "\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        assertThatThrownBy {
            inputReader.readAndGetRounds()
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Rounds must not be empty")
    }

    @Test
    fun `should throw exception when roundNumber is 0`() {
        val input = "0"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        assertThatThrownBy {
            inputReader.readAndGetRounds()
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Rounds should be greater than 0")
    }
}
