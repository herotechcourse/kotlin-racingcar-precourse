package racingcar

object Game {

    fun start() {
        val names = InputView.readCarNames()
        val rounds = InputView.readNumberOfRounds()
        Validator.validateCarNames(names)
        Validator.validateRoundCount(rounds)
        val cars = names.map { Car(it) }
        val race = Race(cars, DefaultNumberGenerator())

        println("\nRace Results")
        race.run(rounds)
        race.getCars().forEach {
            println("${it.name} : ${it.getPositionDisplay()}")
        }
        val winners = race.getWinners().joinToString(", ") { it.name }
        println("\nWinners : $winners")
    }
}
