package racingcar.race

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.main
import racingcar.player.Car

class SimulationTest : NsTest() {

  @Test
  fun `prints no winner message if all cars stay at position 0`() {
    val cars = listOf(Car("x"), Car("y"))
    val totalRounds = 3

    assertRandomNumberInRangeTest(
        {
          Simulation.race(cars, totalRounds)
          cars.forEach { assertThat(it.position).isEqualTo(0) }
          assertThat(output())
              .contains("Probability struck: no car moved and no winner could be declared!")
        },
        // ROUND 1
        STOP,
        STOP,
        // ROUND 2
        STOP,
        STOP,
        // ROUND 3
        STOP,
        STOP)
  }

  @Test
  fun `prints multiple winners`() {
    val cars = listOf(Car("car1"), Car("car2"), Car("car3"))
    val totalRounds = 3

    assertRandomNumberInRangeTest(
        {
          Simulation.race(cars, totalRounds)
          val winnerNames = listOf("car1", "car2", "car3")
          winnerNames.forEach { assertThat(output()).contains(it) }
          assertThat(output()).contains("Winners : car1, car2, car3")
        },
        // ROUND 1
        MOVE,
        STOP,
        MOVE,
        // ROUND 2
        MOVE,
        MOVE,
        MOVE,
        // ROUND 3
        STOP,
        MOVE,
        STOP)
  }

  @Test
  fun `prints only one winner`() {
    val cars = listOf(Car("car1"), Car("car2"), Car("car3"))
    val totalRounds = 3

    assertRandomNumberInRangeTest(
        {
          Simulation.race(cars, totalRounds)
          val winnerNames = listOf("car1", "car2", "car3")
          winnerNames.forEach { assertThat(output()).contains(it) }
          assertThat(output()).contains("Winners : car2")
        },
        // ROUND 1
        MOVE,
        STOP,
        MOVE,
        // ROUND 2
        STOP,
        MOVE,
        STOP,
        // ROUND 3
        STOP,
        MOVE,
        STOP)
  }

  @Test
  fun `car progress updates correctly each round`() {
    val cars = listOf(Car("car1"), Car("car2"))
    val totalRounds = 2

    assertRandomNumberInRangeTest(
        {
          Simulation.race(cars, totalRounds)
          val out = output()
          val lines = out.lines().filter { it.contains("car") }

          // ROUND 1:
          assertThat(lines[0]).contains("car1 : ")
          assertThat(lines[1]).contains("car2 : -")

          // ROUND 2:
          assertThat(lines[2]).contains("car1 : -")
          assertThat(lines[3]).contains("car2 : --")
        },
        // ROUND 1
        STOP,
        MOVE,
        // ROUND 2
        MOVE,
        MOVE)
  }

  @Test
  fun `simulation runs and print each round until totalRounds is reached`() {
    val cars = listOf(Car("a"))
    val totalRounds = 3

    assertRandomNumberInRangeTest(
        {
          Simulation.race(cars, totalRounds)
          val out = output()

          val roundCount = out.lines().count { it.contains("a :") }

          assertThat(roundCount).isEqualTo(totalRounds)
        },
        STOP,
        STOP,
        STOP,
    )
  }

  override fun runMain() {
    main()
  }

  companion object {
    private const val MOVE: Int = 4
    private const val STOP: Int = 3
  }
}
