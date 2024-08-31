interface IFizzBuzz {
    val value: Int
    fun evaluate(): Array<String>
}

class FizzBuzz(override val value: Int) : IFizzBuzz {
    override fun evaluate(): Array<String> {
        return Array(value) { i ->
            val number = i + 1
            when {
                number % 15 == 0 -> "fizzbuzz"
                number % 3 == 0 -> "fizz"
                number % 5 == 0 -> "buzz"
                else -> number.toString()
            }
        }
    }
}

fun getValidInput(): Int {
    while (true) {
        try {
            println("Ingrese un número de rango entre 1 y 100")
            val value = readln().toInt()

            if (value in 1..100) {
                return value
            } else {
                println("Rango no válido. Ingrese un número entre 1 y 100.")
            }
        } catch (e: NumberFormatException) {
            println("Por favor, ingrese un número válido")
        }
    }
}

fun main() {
    val value = getValidInput()

    val fizzBuzz = FizzBuzz(value)
    val results = fizzBuzz.evaluate()

    results.forEachIndexed { index, result ->
        if (index > 0 && index % 10 == 0) println()
        print(result.padEnd(13))
    }
}
