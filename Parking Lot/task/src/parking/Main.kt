package parking

class Car(val registration : String,val color : String)

class ParkingLot(size : Int){
    val spots = Array<Car?>(2) {
        if (it == 0) {
            Car("","")
        } else {
            null
        }
    }

    fun handlePark(car : Car) : String {
        val emptySpot = spots.indexOfFirst { it == null }
        spots[emptySpot] = car
        return "${car.color} car parked in spot ${emptySpot + 1}."
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
    val input = readLine()!!.split(" ")
    val parkingLot = ParkingLot(2)
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
}
