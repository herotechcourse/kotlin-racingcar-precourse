package racingcar.validation

fun validateNatural(num: Int) {
    if (num < 1) throw IllegalArgumentException("Number must be a natural number.");
}