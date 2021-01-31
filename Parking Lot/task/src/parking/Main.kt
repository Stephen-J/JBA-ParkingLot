package parking

class Car(val registration : String,val color : String)

class ParkingLot(size : Int){
    val spots = Array<Car?>(size) {null}

    fun handlePark(car : Car) : String {
        val emptySpot = spots.indexOfFirst { it == null }
        val result = if (emptySpot != -1) {
            spots[emptySpot] = car
            "${car.color} car parked in spot ${emptySpot + 1}."
        } else {
            "Sorry, the parking lot is full."
        }
        return result
    }

    fun handleLeave(spot : Int) : String {
        val result = if (spots[spot - 1] != null) {
            spots[spot - 1] = null
            "Spot $spot is free."
        } else {
            "There is no car in spot $spot."
        }
        return result
    }
}

fun main() {
    val parkingLot = ParkingLot(20)
    var input = readLine()!!.split(" ")
    while(input.first() != "exit"){
        when (input[0]) {
            "park" -> {
                val registration = input[1]
                val color = input[2]
                println(parkingLot.handlePark(Car(registration,color)))
            }
            "leave" -> {
                val lotNumber = input[1].toInt()
                println(parkingLot.handleLeave(lotNumber))
            }
        }
        input = readLine()!!.split(" ")
    }
}
