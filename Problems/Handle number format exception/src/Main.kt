fun parseCardNumber(cardNumber: String): Long {
    val ex = Exception("Invalid Card Number")
    val numbers = cardNumber.split(" ")
    if (numbers.size != 4) throw ex
    return numbers.joinToString("").toLong()
}