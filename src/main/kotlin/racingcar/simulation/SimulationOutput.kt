package racingcar.simulation

import racingcar.Car

/*

Notes to reviewer:

  I chose to isolate all simulation-related output into its own object (`SimulationOutput`)
  to keep responsibilities clearly separated.

  The `addPadding()` function was introduced to centralize and manage visual spacing in the output,
  so to avoid scattered \n and println() nested around other functions just to handle empty lines
  in the output.

  Additionally, I was thinking to have marked this object and its functions as `internal` as from my understanding it
  would limit SimulationOutput() to be used within the Simulation module only.
  However, Gradle file configuration is not allowed and therefore I did not apply this.

  I also had to change my printing logic to accomodate your ApplicationTest file which expected Winners
  to be printed in plural ("Winners") also when we have a single winner. Before noticing and fixing that my
  logic for the print statment in result() would have been the following:

    - println ("Winner${if (winners.size > 1) "s" else ""}: names")

*/

object SimulationOutput {

  fun header() {
    println("Race Results:")
  }

  fun addPadding() {
    println()
  }

  fun round(carProgress: String) {
    println(carProgress)
  }

  fun result(winners: List<Car>) {
    if (winners.isEmpty()) {
      println("Probability struck: no car moved and no winner could be declared!")
    } else {
      val names = winners.joinToString(", ") { it.name }
      println("Winners : $names")
    }
  }
}
