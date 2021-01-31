// do not change this data class
data class Box(val height: Int, val length: Int, val width: Int)

fun main() {
    val input = Array(4){readLine()!!.toInt()}
    val box1 = Box(input[0],input[1],input[3])
    val box2 = box1.copy(length = input[2])
    arrayOf(box1,box2).forEach{println(it)}
}