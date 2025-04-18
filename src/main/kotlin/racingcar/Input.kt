package racingcar

import camp.nextstep.edu.missionutils.Console;

class Input {
    fun getCarNames() : List<String> {
        println("Enter the names of the cars (comma-separated):");
        val carNameInput = Console.readLine();
        validateSpecialCharacter(carNameInput);
        val carNames = carNameInput.split(",");
        validateBlankName(carNames);
        validateNameLength(carNames);
        validateDuplicateName(carNames);
        return carNames;
    }

    fun getRoundCount() : Int {
        println("How many rounds will be played?");
        val roundCountInput = Console.readLine();
        validateNumber(roundCountInput);
        validateNumberRange(roundCountInput);
        val roundCount = roundCountInput.toInt();
        validateNegativeNumberOrZero(roundCount);
        return roundCount;
    }

    fun validateSpecialCharacter(carNameInput: String) : Unit {
        val regex = Regex("[0-9a-zA-Zㄱ-ㅎ가-힣, ]");
        val removeCharacters = regex.replace(carNameInput, "");
        if (!removeCharacters.isEmpty()) {
            throw IllegalArgumentException("콤마를 제외한 특수문자는 사용할 수 없습니다.");
        }
    }

    fun validateBlankName(carNames: List<String>) : Unit {
        for (name in carNames) {
            if (name.equals(" ")) {
                throw IllegalArgumentException("스페이스로만 이루어진 이름은 사용할 수 없습니다.");
            }
            if (name.isBlank()) {
                throw IllegalArgumentException("이름은 최소 1자 이상 가능합니다.");
            }
        }
    }

    fun validateNameLength(carNames: List<String>) : Unit {
        for (name in carNames) {
            if (name.length > 5) {
                throw IllegalArgumentException("이름은 최대 5자까지 가능합니다.")
            }
        }
    }

    fun validateDuplicateName(carNames: List<String>) : Unit {
        for ((index, name) in carNames.withIndex()) {
            if (carNames.indexOf(name) != index) {
                throw IllegalArgumentException("중복된 이름은 사용할 수 없습니다.");
            }
        }
    }

    fun validateNumber(roundCountInput: String) : Unit {
        val regex = Regex("[0-9-]");
        val removeCharacters = regex.replace(roundCountInput, "");
        if (!removeCharacters.isEmpty()) {
            throw IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    fun validateNumberRange(roundCountInput: String) {
        if (roundCountInput.toIntOrNull() == null) {
            throw IllegalArgumentException("라운드는 최대 2,147,483,647이하의 자연수만 입력 가능합니다.");
        }
    }

    fun validateNegativeNumberOrZero(roundCount: Int) {
        if (roundCount <= 0) {
            throw IllegalArgumentException("라운드는 최대 2,147,483,647이하의 자연수만 입력 가능합니다.");
        }
    }
}