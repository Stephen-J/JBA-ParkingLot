fun main() {
    val input : String? = readLine()
    println("Elvis says: ${input ?: throw IllegalStateException()}")
}