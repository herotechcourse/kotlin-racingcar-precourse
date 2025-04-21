package racingcar.controller

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.model.Car
import racingcar.service.RoundHandler
import racingcar.view.InputView
import racingcar.view.OutputView

class GameControllerTest {
    
    private lateinit var testInputView: TestInputView
    private lateinit var testOutputView: TestOutputView
    private lateinit var gameController: GameController
    
    @BeforeEach
    fun setUp() {
        testInputView = TestInputView()
        testOutputView = TestOutputView()
        gameController = GameController(testInputView, testOutputView)
    }
    
    @Test
    fun `start should execute race with correct parameters`() {
        // setup predefined input values
        testInputView.carNamesToReturn = listOf("car1", "car2", "car3")
        testInputView.roundCountToReturn = 3
        
        // run game
        gameController.start()
        
        // verify race results were captured
        assert(testOutputView.raceHeaderCalled) { "Race header was not printed" }
        assert(testOutputView.roundResultCalledCount == 3) { "Round results were not printed 3 times" }
        assert(testOutputView.winnersCalled) { "Winners were not printed" }
        
        // at least one car name should be in the winners
        val winnerNames = testOutputView.lastWinners?.map { it.name } ?: emptyList()
        assert(winnerNames.isNotEmpty()) { "No winners were determined" }
    }
    
    @Test
    fun `start should handle exceptions from input`() {
        // cause an exception
        testInputView.shouldThrowException = true
        
        // Now we expect the exception to be thrown
        assertThrows<IllegalArgumentException> {
            gameController.start()
        }
    }
    
    // Test double for InputView
    private class TestInputView : InputView() {
        var carNamesToReturn = listOf("car1", "car2")
        var roundCountToReturn = 1
        var shouldThrowException = false
        
        override fun readCarNames(): List<String> {
            if (shouldThrowException) {
                throw IllegalArgumentException("Test exception")
            }
            return carNamesToReturn
        }
        
        override fun readRoundCount(): Int {
            if (shouldThrowException) {
                throw IllegalArgumentException("Test exception")
            }
            return roundCountToReturn
        }
    }
    
    // Test double for OutputView
    private class TestOutputView : OutputView() {
        var raceHeaderCalled = false
        var roundResultCalledCount = 0
        var winnersCalled = false
        
        var lastRoundResultCars: List<Car>? = null
        var lastWinners: List<Car>? = null
        
        override fun printRaceHeader() {
            raceHeaderCalled = true
        }
        
        override fun printRoundResult(cars: List<Car>) {
            roundResultCalledCount++
            lastRoundResultCars = cars
            
            // Make at least one car move forward in each round to ensure there are winners
            if (cars.isNotEmpty() && roundResultCalledCount <= 3) {
                cars[0].position++
            }
        }
        
        override fun printWinners(winners: List<Car>) {
            winnersCalled = true
            lastWinners = winners
        }
    }
} 