fun main() {
    val productType = readLine()!!
    val price = readLine()!!.toInt()
    val product = Product.new(productType,price)
    println(product.totalPrice())
}

abstract class Product(private val price: Int, private val tax: Double) {

    fun totalPrice(): Int = (price + price * tax).toInt()

    companion object {
        fun new(productType: String,price: Int) : Product {
            return when (productType.toLowerCase()) {
                "headphones" -> Headphones(price)
                "smartphone" -> Smartphone(price)
                "tv" -> Tv(price)
                "laptop" -> Laptop(price)
                else -> throw Exception("Unknown product")
            }
        }
    }
}

class Headphones(price: Int) : Product(price,tax = 0.11)
class Smartphone(price: Int) : Product(price,tax = 0.15)
class Tv(price: Int) : Product(price,tax = 0.17)
class Laptop(price: Int) : Product(price,tax = 0.19)