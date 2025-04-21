package racingcar.util

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.player.Car
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class CarRaceUtilTest {
    
    private lateinit var carRaceUtil: CarRaceUtil
    private val originalOut = System.out
    private val outputStream = ByteArrayOutputStream()
    
    @BeforeEach
    fun setUp() {
        carRaceUtil = CarRaceUtil()
        System.setOut(PrintStream(outputStream))
    }
    
    @AfterEach
    fun tearDown() {
        System.setOut(originalOut)
    }
    
    @Test
    @DisplayName("readCars should correctly parse car names")
    fun readCars_shouldParseCarNames() {
        // Given
        val inputProvider = { "car1,car2,car3" }
        val validator = { names: List<String>? -> Result.success(names!!) }
        
        // When
        val cars = carRaceUtil.readCars(inputProvider, validator)
        
        // Then
        assertThat(cars).hasSize(3)
        assertThat(cars[0].name).isEqualTo("car1")
        assertThat(cars[1].name).isEqualTo("car2")
        assertThat(cars[2].name).isEqualTo("car3")
        assertThat(cars).allMatch { it.win == 0 }
    }
    
    @Test
    @DisplayName("readCars should trim car names")
    fun readCars_shouldTrimCarNames() {
        // Given
        val inputProvider = { " car1 , car2 , car3 " }
        val validator = { names: List<String>? -> Result.success(names!!) }
        
        // When
        val cars = carRaceUtil.readCars(inputProvider, validator)
        
        // Then
        assertThat(cars).hasSize(3)
        assertThat(cars[0].name).isEqualTo("car1")
        assertThat(cars[1].name).isEqualTo("car2")
        assertThat(cars[2].name).isEqualTo("car3")
    }
    
    @Test
    @DisplayName("readCars should filter empty names")
    fun readCars_shouldFilterEmptyNames() {
        // Given
        val inputProvider = { "car1,,car3" }
        val validator = { names: List<String>? -> Result.success(names!!) }
        
        // When
        val cars = carRaceUtil.readCars(inputProvider, validator)
        
        // Then
        assertThat(cars).hasSize(2)
        assertThat(cars[0].name).isEqualTo("car1")
        assertThat(cars[1].name).isEqualTo("car3")
    }
    
    @Test
    @DisplayName("readCars should throw exception when validator fails")
    fun readCars_shouldThrowExceptionWhenValidatorFails() {
        // Given
        val inputProvider = { "car1,car2,car3" }
        val exception = IllegalArgumentException("Invalid car names")
        val validator = { _: List<String>? -> Result.failure<List<String>>(exception) }
        
        // Then
        assertThatThrownBy { carRaceUtil.readCars(inputProvider, validator) }
            .isEqualTo(exception)
    }
    
    @Test
    @DisplayName("printRaceResult should output correctly formatted race results")
    fun printRaceResult_shouldOutputFormattedResults() {
        // Given
        val round1 = listOf(
            Car("car1", 1),
            Car("car2", 2),
            Car("car3", 0)
        )
        val round2 = listOf(
            Car("car1", 2),
            Car("car2", 3),
            Car("car3", 1)
        )
        val result = listOf(round1, round2)
        val winners = listOf(Car("car2", 3))
        
        // When
        carRaceUtil.printRaceResult(result, winners)
        val output = outputStream.toString()
        
        // Then
        assertThat(output).contains("Race Results")
        assertThat(output).contains("car1 : -")
        assertThat(output).contains("car2 : --")
        assertThat(output).contains("car3 : ")
        assertThat(output).contains("car1 : --")
        assertThat(output).contains("car2 : ---")
        assertThat(output).contains("car3 : -")
        assertThat(output).contains("Winners : car2")
    }
    
    @Test
    @DisplayName("printRaceResult should handle multiple winners")
    fun printRaceResult_shouldHandleMultipleWinners() {
        // Given
        val round1 = listOf(Car("car1", 1), Car("car2", 1))
        val result = listOf(round1)
        val winners = listOf(Car("car1", 1), Car("car2", 1))
        
        // When
        carRaceUtil.printRaceResult(result, winners)
        val output = outputStream.toString()
        
        // Then
        assertThat(output).contains("Winners : car1, car2")
    }
}
