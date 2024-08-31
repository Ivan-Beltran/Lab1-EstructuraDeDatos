import java.lang.NumberFormatException

interface IBaseNumber {
    val value: Int
    fun PrintValues()
}

class OddNumbers(override val value: Int) : IBaseNumber {
    private val divisors = mutableMapOf<Int, MutableList<Int>>()

    init {
        OddAndDivisors()
    }

    override fun PrintValues() {
        val oddCount = divisors.size
        println("Números impares: $oddCount")
    }

    private fun OddAndDivisors() {
        for (i in 1..value) {
            if (i % 2 != 0) {
                divisors[i] = findDivisors(i).toMutableList()
            }
        }
    }

    private fun findDivisors(number: Int): List<Int> {
        return (1..number).filter { number % it == 0 }
    }
}

class EvenNumbers(override val value: Int) : IBaseNumber {
    private val divisors = mutableMapOf<Int, MutableList<Int>>()

    init {
        EvenAndDivisors()
    }

    override fun PrintValues() {
        val evenCount=divisors.size
        println("Números pares: $evenCount")
    }

    private fun EvenAndDivisors() {
        for (i in 1..value) {
            if (i % 2 == 0){
                divisors[i]=findDivisors(i).toMutableList()
            }
        }
    }
    private fun findDivisors(number: Int): List<Int> {
        return (1..number).filter { number % it == 0 }
    }
}

class PrimeNumbers(override val value: Int) : IBaseNumber {
    private var primeCount = 0

    init {
        AddPrime()
    }

    override fun PrintValues() {
        println("Números primos: $primeCount")
    }

    private fun AddPrime() {
        for (i in 2..value) {
            if (isPrime(i)) primeCount++
        }
    }

    private fun isPrime(number: Int): Boolean {
        if (number < 2) return false
        for (i in 2 until number) {
            if (number % i == 0) return false
        }
        return true
    }
}

class BaseNumber(override val value: Int) : IBaseNumber {
    private val oddNumbers = OddNumbers(value)
    private val evenNumbers = EvenNumbers(value)
    private val primeNumbers = PrimeNumbers(value)

    override fun PrintValues() {
        println("rango a evaluar 1 a : ${value}")
        oddNumbers.PrintValues()
        evenNumbers.PrintValues()
        primeNumbers.PrintValues()
    }
}

fun main() {
    var number: Int? =null
    while (number == null || number <= 0) {
        println("Ingrese un número positivo:")

        try {
            number = readLine()?.toInt()

            if (number == null || number <= 0) {
                println("Número no válido. Debe ser un número entero positivo.")
            }
        } catch (e: NumberFormatException) {
            println("Dato no válido. Por favor, ingrese un número entero.")
        }
    }
    val process = BaseNumber(number)
    process.PrintValues()
}


