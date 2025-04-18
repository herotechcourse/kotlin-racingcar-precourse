package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

/**
 * Racing game
 * @property cars Cars participating in the race
 * @property rounds Number of rounds
 */
class RacingGame(private val cars: Cars, private val rounds: Int) {
    private val roundResults = mutableListOf<List<Car>>()

    /**
     * Executes the race
     * @return Race results
     */
    fun race(): List<List<Car>> {
        repeat(rounds) {
            playOneRound()
        }
        return roundResults
    }

    /**
     * Plays one round of the race
     */
    private fun playOneRound() {
        val randomNumbers = generateRandomNumbers()
        cars.moveAll(randomNumbers)
        roundResults.add(cars.getCars())
    }

    /**
     * Generates random numbers for each car
     * @return List of random numbers
     */
    private fun generateRandomNumbers(): List<Int> {
        return cars.getCars().map { 
            Randoms.pickNumberInRange(0, 9) 
        }
    }

    /**
     * Gets winners
     * @return List of winners
     */
    fun getWinners(): List<Car> {
        return cars.getWinners()
    }
} 