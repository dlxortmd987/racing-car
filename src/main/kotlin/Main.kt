import domain.*
import io.*

private val processHistoryManager = ProcessHistoryManager()

fun main() {
    printNamesGuideMessage()
    val names = scan(",")
    printTryGuideMessage()
    val tryNumber = scan().toInt()

    val application = Application(names, tryNumber, processHistoryManager)
    val result = application.process()

    printHistory(processHistoryManager)

    printWinners(result)
}