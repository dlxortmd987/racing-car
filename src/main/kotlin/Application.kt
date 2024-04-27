import domain.Candidate
import domain.CarMoveService
import domain.RaceMetaData
import io.IoService
import io.RaceResults
import io.UserInput

class Application {
    private val ioService = IoService()
    private val carMoveService = CarMoveService()

    fun getUserInput(): UserInput {
        val cars = ioService.getCars()

        val moveCount = ioService.getMoveCount()

        return UserInput.of(cars, moveCount)
    }

    fun race(metadata: RaceMetaData): RaceResults {
        return repeatMove(metadata)
    }

    private fun repeatMove(metadata: RaceMetaData): RaceResults {
        val raceResults = RaceResults.newInstance()

        repeat(metadata.getMoveCount()) {
            val movedCars = carMoveService.moveCars(metadata.getCars())
            raceResults.writeHistory(movedCars)
        }

        return raceResults
    }

    fun showResult(raceResult: RaceResults) {
        ioService.showResult(raceResult)

        val winners = Candidate.findWinners(raceResult.mapTo())
        ioService.showWinners(winners)
    }
}