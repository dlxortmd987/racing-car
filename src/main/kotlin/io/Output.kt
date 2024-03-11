package io

import domain.ProcessHistoryManager

fun printNamesGuideMessage() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
}

fun printTryGuideMessage() {
    println("시도할 회수는 몇회인가요?")
}

fun printHistory(historyManager: ProcessHistoryManager) {
    println(historyManager.getHistory())
}

fun printWinners(winners: List<String>) {
    println("최종 우승자: ${winners.joinToString(", ")}")
}