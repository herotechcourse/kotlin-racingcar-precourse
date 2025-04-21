package racingcar

object Game {

    fun play(names: List<String>, rounds: Int, generator: NumberGenerator): Race {
        Validator.validateCarNames(names)
        Validator.validateRoundCount(rounds)
        val cars = names.map { Car(it) }
        val race = Race(cars, generator)
        race.run(rounds)
        return race
    }

    fun start() {
        val names = InputView.readCarNames()
        val rounds = InputView.readNumberOfRounds()
        val race = play(names, rounds, DefaultNumberGenerator())

        println("\nRace Results")
        race.getCars().forEach {
            println("${it.name} : ${it.getPositionDisplay()}")
        }

        println("\nWinners : ${race.getWinners().joinToString(", ") { it.name }}")
    }
}
