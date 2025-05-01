package racingcar

object Input {
    fun <T>nameToEntity(strArgs : String) : List<Vehicle> where T : Vehicle {
        val list = mutableListOf<Vehicle>()

        strArgs.split(",").map {
            it.trim()
            if(validString(it)) {
                list.add(makeVehicle(constructor = ::Car, args = it))
            }
            else throw IllegalArgumentException(myConstErrorMessage.WRONG_NAME)
        }
        return list
    }
}

object Output {
    fun printVehicleWinners(winners: List<Vehicle>) {
        val string = winners.joinToString(", ") { v -> v.name }
        println("Winners : $string")
    }
    fun printVehicleScores(vehicles: List<Vehicle>) {
        vehicles.map { println("${it.name} : ${it.positionLine()}") }
    }
}
/*
*파일 나눈 기준
* 처음
* 메인 실행
*
* 레이싱 게임
*
* 차
*
* 이후
*
* 차의 확장성
* 추상클래스(차량) 추가
* 차량 객체 생성시 기존의 name과 position외의 추가 입력을 대비해 arg로
* 차량 상속받은 객체는 받아야하며 init에서 그것을 가공해야한다
*
* 입출력
* 게임내에서 입, 출력 관리 -> View파일 내에 입출력을 관리하도록 관린
*
* 실행시
* 추가기능 고려
* 자동차 -> 트럭 객체 변경 -> 인터페이스 선언
* 점수선정방식변경
*
* 에러
* 에러 메세지 매칭 -> 오브젝트로 관리 enum?
*
* */