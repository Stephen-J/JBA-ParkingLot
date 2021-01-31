fun convertStringToDouble(input: String) : Double {
    var result = 0.0
    try {
        result = input.toDouble()
    } catch (ex: Exception) {
        // ignore errors resulting in returning 0.0
    }
    return result
}
