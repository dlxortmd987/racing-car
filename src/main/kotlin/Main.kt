


fun main() {
    val application = Application()
    val userInput = application.getUserInput()
    val raceResult = application.race(userInput.mapTo())
    application.showResult(raceResult)
}