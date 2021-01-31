fun printFifthCharacter(input: String): String {
    return try {
        "The fifth character of the entered word is ${input[4]}"
    } catch (e : Exception) {
        "The input word is too short!"
    }
}