package domain

class ProcessHistoryManager {

    private val processHistory = StringBuilder()

    fun append(car: Car) {
        val processResult = ProcessResult.from(car)
        processHistory.append("${processResult.name} : ${processResult.progress}\n")
    }

    fun appendLineBreak() {
        processHistory.append("\n")
    }

    fun getHistory(): java.lang.StringBuilder {
        return processHistory
    }
}