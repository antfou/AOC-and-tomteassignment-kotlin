package TwentyFifteen.Day2

import org.junit.jupiter.api.Test

class TwoTests {

    @Test
    fun convertStringToListOfIntsThatContains3ValuesTest(){
        val logic = aocTwoAMain()
        val input = "27x26x11"
        val expectedSize = 3
        val expectedValue = 11

        assert(logic.convertStringToListOfIntsThatContains3Values(input).size.equals(expectedSize))
        assert(logic.convertStringToListOfIntsThatContains3Values(input).get(2).equals(expectedValue))

    }

    @Test
    fun calculationTest(){
        val logic = aocTwoAMain()
        val expectedValue = 58
        val input1 = 4
        val input2 = 2
        val input3 = 3

        assert(logic.calculation(input1,input2,input3).equals(expectedValue))

    }

    @Test
    fun calculateWrappingPaperNeededTest(){
        val logic = aocTwoAMain()
        val expectedValue = 6659
        val filepath = "src/test/resources/TwentyFifteen.Inputs/Input/Day2/TwoTestInput"
        val input = logic.getStringListFromFile(filepath)

        assert(logic.calculateWrappingPaperNeeded(input).equals(expectedValue))

    }

    @Test
    fun calculationTestRevisited(){
        val logic = aocTwoMainRevisited()
        val expectedValue = 58
        val input = listOf(4,2,3)


        assert(logic.calculation(input).equals(expectedValue))

    }

    @Test
    fun calculateWrappingPaperNeededTestRevisited(){
        val logic = aocTwoMainRevisited()
        val expectedValue = 6659
        val filepath = "src/test/resources/TwentyFifteen.Inputs/Input/Day2/TwoTestInput"
        val input = logic.getStringListFromFile(filepath)
        assert(logic.calculateWrappingPaperNeeded(logic.convertStringListToListListOfIntsThatContains3Values(input)).equals(expectedValue))

    }

    @Test
    fun calculationBTest(){
        val logic = aocTwoBMain()
        val expectedValue = 34
        val input = listOf(4,2,3)

        assert(logic.calculation(input).equals(expectedValue))

    }
}