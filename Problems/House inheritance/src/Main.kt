class House(val rooms: Int, val price: Int)

fun totalPrice(house : House) : Int {
    val coefficient = when {
        house.rooms <= 1 -> 1.0
        house.rooms in 2..3 -> 1.2
        house.rooms == 4 -> 1.25
        house.rooms in 5..7 -> 1.4
        house.rooms >= 8 -> 1.6
        else -> 0.0
    }
    val basePrice = when {
        house.price <= 0 -> 0
        house.price >= 1_000_000 -> 1_000_000
        else -> house.price
    }
    return (coefficient * basePrice).toInt()
}

fun main() {
    val rooms = readLine()!!.toInt()
    val price = readLine()!!.toInt()
    val house = House(rooms, price)
    println(totalPrice(house))
}


