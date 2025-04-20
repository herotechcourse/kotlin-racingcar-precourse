package racingcar.view

import org.junit.jupiter.api.*
import racingcar.model.Car
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ResultViewTest {

    private val standardOut = System.out
    private lateinit var outContent: ByteArrayOutputStream

    @BeforeEach
    fun setUp() {
        outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }

    @Test
    @DisplayName("given a round snapshot when printRound then prints each car and hyphens")
    fun `given round snapshot when printRound then prints each car and hyphens`() {
        // given
        val snapshot = listOf(
            Car(name = "pobi", position = 2),
            Car(name = "jun", position = 1)
        )

        // when
        ResultView.printRound(snapshot)

        // then
        val expected = buildString {
            append("pobi : --\n")
            append("jun : -\n")
            append("\n")  // 추가된 빈 줄
        }
        Assertions.assertEquals(expected, outContent.toString())
    }

    @Test
    @DisplayName("given winner list when printWinners then prints blank line and Winners label")
    fun `given winner list when printWinners then prints blank line and Winners label`() {
        // given
        val winners = listOf("pobi", "jun")

        // when
        ResultView.printWinners(winners)

        // then
        val expected = "Winners : pobi, jun\n"
        Assertions.assertEquals(expected, outContent.toString())
    }
}