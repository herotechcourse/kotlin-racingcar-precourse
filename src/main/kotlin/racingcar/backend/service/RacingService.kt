package racingcar.backend.service

import camp.nextstep.edu.missionutils.Randoms
import racingcar.backend.domain.Car
import racingcar.backend.domain.Race
import racingcar.backend.domain.validator.RaceNameValidator
import racingcar.backend.domain.validator.RoundValidator
import racingcar.backend.dto.*
import racingcar.backend.util.StringParser

class RacingService {
    fun inputCarNames(request: CarNameRequest): List<CarDto> {
        val nameList = StringParser.parseCommaSeperated(request.carNames)
        validateCarNames(nameList)
        return convertToCarDto(nameList)
    }

    private fun validateCarNames(nameList: List<String>) {
        nameList.forEach { carName ->
            RaceNameValidator.validateCarNameIsBlank(carName)
            RaceNameValidator.validateCarNameLength(carName)
        }
        RaceNameValidator.validateDuplicateCarNames(nameList)
        RaceNameValidator.validateMinimumNumberOfCars(nameList)
    }

    private fun convertToCarDto(nameList: List<String>): List<CarDto> {
        return nameList.map { carName ->
            CarDto(carName = carName)
        }
    }

    fun convertRoundToNum(roundRequest: RoundRequest): Int {
        validateRound(roundRequest.round)
        return roundRequest.round.toInt()
    }

    private fun validateRound(round: String) {
        RoundValidator.validateRound(round)
        RoundValidator.validatePositiveRound(round.toInt())
    }

    fun outputRaceResults(raceRequest: RaceRequest): RaceResponse {
        val carList = convertToCarList(raceRequest.carList)
        val raceList = raceStart(carList, raceRequest.roundCount)
        val raceResultList = convertToRaceResultList(raceList)
        val winnerList = calculateWinners(raceResultList)

        return RaceResponse(roundNum = raceRequest.roundCount, raceResultList = raceResultList, winnerList = winnerList)
    }


    private fun convertToCarList(carDtoList: List<CarDto>): List<Car> {
        return carDtoList.map { car ->
            Car(name = car.carName)
        }
    }

    private fun raceStart(carList: List<Car>, roundCount: Int): List<Race> {
        val raceList = carList.map { Race(it) }
        repeat(roundCount) {
            raceList.forEach { race ->
                if (Randoms.pickNumberInRange(0, 9) >= 4) race.move() else race.stay()
            }
        }
        return raceList
    }

    private fun convertToRaceResultList(raceList: List<Race>): List<RaceResponse.RaceResult> {
        return raceList.map {
            RaceResponse.RaceResult(carName = it.car.name, positions = it.position)
        }
    }

    private fun calculateWinners(resultList: List<RaceResponse.RaceResult>): List<String> {
        val maxPosition = resultList.maxOf { raceResult ->
            raceResult.positions.last().length
        }

        return resultList.filter { it.positions.last().length == maxPosition }.map { it.carName }
    }
}