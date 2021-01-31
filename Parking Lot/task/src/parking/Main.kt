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

    fun handleRegByColor(color: String) : String {
        val result = spots.filter { it?.color.equals(color, ignoreCase = true) }
        return if (result.isEmpty()) {
            "No cars with color $color were found."
        } else {
            result.map {it?.registration}.joinToString(", ")
        }
    }

    fun handleSpotByReg(registration: String) : String {
        val results = mutableListOf<Int>()
        spots.onEachIndexed{i,car ->
            if (car?.registration.equals(registration, ignoreCase = true)) results.add(i + 1)
        }
        return if (results.isEmpty()) {
            "No cars with registration number $registration were found."
        } else {
            results.joinToString(", ")
        }
    }

    fun handleSpotByColor(color: String) : String {
        val results = mutableListOf<Int>()
        spots.onEachIndexed{i,car ->
            if (car?.color.equals(color, ignoreCase = true)) results.add(i + 1)
        }
        return if (results.isEmpty()) {
            "No cars with color $color were found."
        } else {
            results.joinToString(", ")
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
                "reg_by_color" -> {
                    val color = input[1]
                    println(parkingLot.handleRegByColor(color))
                }
                "spot_by_reg" -> {
                    val registration = input[1]
                    println(parkingLot.handleSpotByReg(registration))
                }
                "spot_by_color" -> {
                    val color = input[1]
                    println(parkingLot.handleSpotByColor(color))
                }
                else -> println("Unknown Command")
            }

        }
        input = readLine()!!.split(" ")
    }
}
