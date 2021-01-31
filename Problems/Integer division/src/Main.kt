import java.lang.ArithmeticException
import java.lang.NumberFormatException

fun intDivision(x: String,y: String) : Int {
    var result = 0
    try {
        val x1 = x.toInt()
        val y1 = y.toInt()
        result =  x1 / y1
    } catch (ex: NumberFormatException) {
        println("Read values are not integers.")
    } catch (ex: ArithmeticException) {
        println("Exception: division by zero!")
    }
    return result
}

fun main() {
    val x = readLine()!!
    val y = readLine()!!
    println(intDivision(x, y))
}
