package racingcar

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

 class RaceTest {
  @Test
  fun `winner with max displacement`() {
   val car1 = Car("car1").apply {
    repeat(4) {
     forceMove(3) }
   }
  val car2 = Car("car2").apply {
   repeat(4) { forceMove(7) }
  }
  val race = Race(listOf(car1, car2), 4)
  val winners = race.getWinners()
  assertEquals(listOf("car2"), winners)
 }

  @Test
  fun `tie race`() {
      val car1 = Car("car1").apply {
          repeat(4) {
              forceMove(5)
          }
      }
      val car2 = Car("car2").apply {
          repeat(4) {
              forceMove(4)
          }
      }
   val race = Race(listOf(car1, car2), 4)
   val winners = race.getWinners()
   assertEquals(winners.sorted(),listOf("car1", "car2").sorted())
  }
 }