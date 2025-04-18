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
        for (name in carNames) {
            if (carNames.contains(name)) {
                throw IllegalArgumentException("중복된 이름은 사용할 수 없습니다.");
            }
        }
    }
}