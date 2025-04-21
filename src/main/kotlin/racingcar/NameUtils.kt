package racingcar

fun List<String>.withUniqueNames(): List<String> {
    val nameCount = mutableMapOf<String, Int>()
    return this.map { name ->
        val count = nameCount.getOrDefault(name, 0)
        nameCount[name] = count + 1
        if (count == 0 ) name else "$name(${count + 1})"
    }
}