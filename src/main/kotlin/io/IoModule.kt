package io

private const val CAR_NAME_SEPARATOR = ","

class IoModule {
    fun getCarNames(): List<String> {
        println("경주 할 자동차 이름($CAR_NAME_SEPARATOR 로 구분)")

        val raw = readLine()

        if (raw.isNullOrBlank()) {
            throw IllegalArgumentException()
        }

        return raw.split(CAR_NAME_SEPARATOR)
    }

    fun showNameError() {
        println("[ERROR]: 이름이 5글자 이상입니다.")
    }

    fun getMoveCount(): Int {
        println("시도할 횟수")

        return readLine()?.toIntOrNull() ?: throw IllegalArgumentException()
    }

    fun showCountError() {
        println("[ERROR]: 숫자형이 아닙니다.")
    }
}