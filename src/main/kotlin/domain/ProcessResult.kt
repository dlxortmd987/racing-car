package domain

class ProcessResult private constructor(val name: String, val progress: String) {

    companion object {
        var progressMap: Map<Int, String> = mapOf(
            0 to "",
            1 to "-",
            2 to "--",
            3 to "---",
            4 to "----",
            5 to "-----",
        )

        fun from(car: Car): ProcessResult {
            return ProcessResult(car.getName(), progressMap[car.getPosition()]!!)
        }
    }
}