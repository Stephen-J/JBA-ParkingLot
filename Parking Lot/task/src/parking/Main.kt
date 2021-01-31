package parking

class Car(val registration : String,val color : String)

class ParkingLot(size : Int){
    private val spots = Array<Car?>(size) {null}

    private fun isEmpty() = spots.any{it != null}

    fun handlePark(car: Car): String {
        val emptySpot = spots.indexOfFirst { it == null }
        return if (emptySpot != -1) {
            spots[emptySpot] = car
            "${car.color} car parked in spot ${emptySpot + 1}."
        } else {
            "Sorry, the parking lot is full."
        }
    }

    fun handleLeave(spot: Int): String {
        return if (spots[spot - 1] != null) {
            spots[spot - 1] = null
            "Spot $spot is free."
        } else {
            "There is no car in spot $spot."
        }
    }

    fun handleStatus() : String {
        return if (isEmpty()) {
            val results = mutableListOf<String>()
            spots.mapIndexed { i,car ->
                if (car != null) {
                    results += "${i + 1} ${car.registration} ${car.color}"
                }
            }
            results.joinToString("\n")
        } else {
            "Parking lot is empty."
        }

    }
}

fun main() {
    var parkingLot : ParkingLot? = null
    var input = readLine()!!.split(" ")
    while(input.first() != "exit"){
        if (parkingLot == null) {
            when (input[0]) {
                "create" -> {
                    val size = input[1].toInt()
                    parkingLot = ParkingLot(size)
                    println("Created a parking lot with $size spots.")
                }
                else -> {
                    println("Sorry, a parking lot has not been created.")
                }
            }
        } else {
            when (input[0]) {
                "create" -> {
                    val size = input[1].toInt()
                    parkingLot = ParkingLot(size)
                    println("Created a parking lot with $size spots.")
                }
                "park" -> {
                    val registration = input[1]
                    val color = input[2]
                    println(parkingLot.handlePark(Car(registration,color)))
                }
                "leave" -> {
                    val lotNumber = input[1].toInt()
                    println(parkingLot.handleLeave(lotNumber))
                }
                "status" -> println(parkingLot.handleStatus())
                else -> println("Unknown Command")
            }

        }

        input = readLine()!!.split(" ")
    }
}
