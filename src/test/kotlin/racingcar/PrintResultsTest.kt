package racingcar
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.assertj.core.api.Assertions.assertThat

class PrintResultsTest {

    @Test
    fun `should print car round result correctly` () {
        val car = mutableMapOf("car1" to "-").entries.first()
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        printRound(car)

        val output = outputStream.toString().trim()
        assertThat(output).isEqualTo("car1 : -")
    }

    @Test
    fun `should print winners correctly`() {
        val cars = mutableMapOf("car1" to "--", "car2" to "-", "car3" to "--")
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        printWinners(cars)

        val output = outputStream.toString().trim()
        assertThat(output).isEqualTo("Winners : car1, car3")
    }
}