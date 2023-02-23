package Day1

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day1Tests {

    @Test
    internal fun `Solution part 1 expected is 198`() {
        val filepath = "src/test/resources/TwentyNineteen/Day1/testInput.txt"
        val input = readTextFromFile(filepath)
        val expected = 198

        assert(solution1(input).equals(expected))
    }
    @Test
    internal fun `Solution part 1 expected is 3495189`() {
        val filepath = "src/main/resources/TwentyNineteen/Day1/actualInput"
        val input = readTextFromFile(filepath)
        val expected = 3495189

        assert(solution1(input).equals(expected))
    }

    @Test
    internal fun `Solution part 1 expected is ???`() {
        val filepath = "src/test/resources/TwentyNineteen/Day1/testInput.txt"
        val input = readTextFromFile(filepath)
        val expected = 272

        assert(solution2(input).equals(expected))

    }

    @Test
    internal fun `Solution part 2 expected is ???`() {
        val filepath = "src/main/resources/TwentyNineteen/Day1/actualInput"
        val input = readTextFromFile(filepath)
        val expected = 5239910

        assert(solution2(input).equals(expected))
    }

    @Nested
    inner class mathOperationsTest{
        @Test
        internal fun `Test math calculation expected is 2`() {
            val input = 12
            val expected = 2

            assert(fuelCalculation(input).equals(expected))
        }

        @org.junit.jupiter.api.Test
        internal fun `Test for fuel loop expected is 966`() {
            val input = 1969
            val expected = 966

            assert(fuelLoop(input).equals(expected))
        }
    }
}