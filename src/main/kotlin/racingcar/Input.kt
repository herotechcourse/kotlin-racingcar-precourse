package racingcar

/**
 * @packageName    : racingcar
 * @fileName       : Input
 * @author         : yong
 * @date           : 4/16/25
 * @description    :
 */
class Input {
    fun input(): String {
        return readln()
    }

    fun getNames(input: String): List<String> {
        val names: List<String> = input.split(",").map { it.trim() }

        if (names.size != names.toSet().size) {
            throw IllegalArgumentException("There is duplicated name")
        }
        for (i in 0 until names.size) {
            if (names[i].length >= 5) {
                throw IllegalArgumentException("name should be under 5 letters")
            }
            if (names[i].isEmpty()) {
                throw IllegalArgumentException("name is empty")
            }
        }
        return names
    }
}