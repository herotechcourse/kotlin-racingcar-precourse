package racingcar.domain.generator

interface NumberGenerator {

    fun nextInt(min: Int, max: Int): Int
}
