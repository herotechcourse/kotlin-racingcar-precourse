package racingcar

object Game {

    fun play(names: List<String>, rounds: Int, generator: NumberGenerator): List<String> {
        Validator.validateCarNames(names)
        Validator.validateRoundCount(rounds)
        val cars = names.map { Car(it) }
        val race = Race(cars, generator)
        race.run(rounds)
        return race.getWinners().map { it.name }
    }

    fun start() {
        val names = InputView.readCarNames()
        val rounds = InputView.readNumberOfRounds()
        val winners = play(names, rounds, DefaultNumberGenerator())

        println("\nRace Results")
        val race = Race(names.map { Car(it) }, DefaultNumberGenerator())
        race.run(rounds)
        race.getCars().forEach {
            println("${it.name} : ${it.getPositionDisplay()}")
        }

        println("\nWinners : ${winners.joinToString(", ")}")
    }


}
