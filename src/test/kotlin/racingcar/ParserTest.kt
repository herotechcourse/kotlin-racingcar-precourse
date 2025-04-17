package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.parser.Parser
import racingcar.utils.ErrorMessages


class ParserTest {

  @Test
  fun `parses valid car names into list of Car`() {
    val input = "audi,ford,bmw"
    val cars = Parser.parseCars(input)

    assertThat(cars).hasSize(3)
    assertThat(cars.map { it.name }).containsExactly("audi", "ford", "bmw")
  }

  @Test
  fun `trims whitespace from car names`() {
    val input = "  audi , ford ,  bmw  "
    val cars = Parser.parseCars(input)

    assertThat(cars.map { it.name }).containsExactly("audi", "ford", "bmw")
  }

  @Test
  fun `throws exception if any car name is empty`() {
    val input = "audi,,bmw"

    assertThatThrownBy { Parser.parseCars(input) }
      .isInstanceOf(IllegalArgumentException::class.java)
      .hasMessage(ErrorMessages.ERROR_EMPTY_CAR_NAME)
  }

  @Test
  fun `throws exception if any car name exceeds 5 characters`() {
    val input = "audi,chevrolet,bmw"

    assertThatThrownBy { Parser.parseCars(input) }
      .isInstanceOf(IllegalArgumentException::class.java)
      .hasMessage(ErrorMessages.ERROR_LONG_CAR_NAME)
  }
}
