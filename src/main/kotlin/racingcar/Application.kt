package racingcar

fun main() {
    val config = FixedRoundsRaceConfiguration.fromStdIn()
    val raceResult = FixedRoundsRace(config).run()

    raceResult.print()
}
