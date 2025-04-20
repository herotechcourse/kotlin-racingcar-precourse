package racingcar.input

import camp.nextstep.edu.missionutils.Console
import racingcar.input.validation.validateCarName
import racingcar.input.validation.validateNatural
import racingcar.input.validation.validateNumberFormat
import racingcar.input.util.getCarNamesFromInput


fun readLineAndProcess(): String {
    val line: String? = Console.readLine();
    if(line.isNullOrBlank())
        throw IllegalArgumentException();
    return line;
}

fun readLineAndGetCars(): Array<String>{
    val nameInput: String = readLineAndProcess();
    val cars = getCarNamesFromInput(nameInput);

    cars.forEach {
            car -> validateCarName(car);
    }

    return cars;
}

fun readLineAndGetRounds(): Int {
    val roundsInput: String = readLineAndProcess();
    validateNumberFormat(roundsInput);

    val rounds: Int = Integer.parseInt(roundsInput);
    validateNatural(rounds);

    return rounds;
}
