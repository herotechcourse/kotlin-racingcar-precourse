package racingcar.error

enum class RacingException(private val message: String) {

    NO_INPUT_ERROR("값을 입력하세요."),
    WRONG_FORMAT_ERROR("잘못된 형식의 입력입니다."),
    DUPLICATE_CAR_NAME_ERROR("자동차 이름이 중복되었습니다."),
    CAR_NAME_LENGTH_ERROR("자동차 이름의 길이는 1이상 5이하 이어야 합니다."),
    WRONG_COUNT_ERROR("시도 횟수는 자연수이어야 합니다.");

    companion object {
        private const val PREFIX = "[error] "
    }

    fun getDescription(): String {
        return PREFIX + message
    }
}