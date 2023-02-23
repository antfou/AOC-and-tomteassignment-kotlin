package TwentyTwentyOne.Day3


import org.junit.jupiter.api.Test
import kotlin.text.StringBuilder

class ThreeTests {

    @Test
    fun calculateEnergyConsumptionTest(){
        val logic = aocThreeAMain()
        val filePath = "src/test/resources/TwentyTwentyOne/Inputs/Day3/ThreeTestInput"
        val expected = 198

        assert(logic.calculateEnergyConsumption(logic.getListFromFile(filePath)).equals(expected))
    }

    @Test
    fun countZeroesAndOnesTest(){
        val logic = aocThreeAMain()
        val expectedFirst = 5
        val expectedSecond = 7
        val filePath = "src/test/resources/TwentyTwentyOne/Inputs/Day3/ThreeTestInput"
        val column = 0

        assert(logic.countZeroesAndOnes(logic.getListFromFile(filePath),column).first.equals(expectedFirst))
        assert(logic.countZeroesAndOnes(logic.getListFromFile(filePath),column).second.equals(expectedSecond))
    }

    @Test
    fun getBinaryValueTest(){
        val logic = aocThreeAMain()
        val expected = 22
        var input = StringBuilder()
        input.append(10110)

        assert(logic.getBinaryValue(input).equals(expected))
    }

    @Test
    fun calculateEnergyConsumptionReduxTest(){
        val logic = newAocThreeAMain()
        val filePath = "src/test/resources/TwentyTwentyOne/Inputs/Day3/ThreeTestInput"
        val expected = 198

        assert(logic.calculateEnergyConsumption(logic.getListFromFile(filePath)).equals(expected))
    }

    @Test
    fun countZeroesAndOnesReduxTest(){
        val logic = newAocThreeAMain()
        val expectedFirst = 5
        val expectedSecond = 7
        val filePath = "src/test/resources/TwentyTwentyOne/Inputs/Day3/ThreeTestInput"
        val column = 0

        assert(logic.countZeroesAndOnes(logic.getListFromFile(filePath),column).first.equals(expectedFirst))
        assert(logic.countZeroesAndOnes(logic.getListFromFile(filePath),column).second.equals(expectedSecond))
    }
}