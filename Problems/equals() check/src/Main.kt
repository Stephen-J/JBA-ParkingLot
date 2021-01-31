data class Client(val name: String, val age: Int, val balance: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Client
        return name == other.name && age == other.age
    }
}

fun main() {
    val clients = Array(2) {
        val name = readLine()!!
        val age = readLine()!!.toInt()
        val balance = readLine()!!.toInt()
        Client(name,age,balance)
    }
    println(clients[0] == clients[1])
}
