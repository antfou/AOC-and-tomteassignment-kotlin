package TwentyFifteen.Day1


import org.junit.jupiter.api.Test

class OneTests {

    @Test
    fun getStringFromFileTest(){
        val logic = aocOneAMain()
        val expected = 5
        val filePath = "src/test/resources/TwentyFifteen.Inputs/Input/Day1/OneTestInput"
        assert(logic.getStringFromFile(filePath).length.equals(expected))
    }

    @Test
    fun calculateFloorTest(){
        val logic = aocOneAMain()
        val expected = 3
        val filePath = "src/test/resources/TwentyFifteen.Inputs/Input/Day1/OneTestInput"
        val string = logic.getStringFromFile(filePath)

        assert(logic.calculateFloor(string).equals(expected))
    }

    @Test
    fun calculateFloorB(){
        val logic = aocOneBMain()
        val expected = 7
        val filePath = "src/test/resources/TwentyFifteen.Inputs/Input/Day1/OneTestInputRevisited"
        val string = logic.getStringFromFile(filePath)

        assert(logic.calculateFloor(string).equals(expected))
    }

    @Test
    fun calculateFloorBRevisited(){
        val logic = aocOneBMainRevisited()
        val expected = 7
        val filePath = "src/test/resources/TwentyFifteen.Inputs/Input/Day1/OneTestInputRevisited"
        val string = logic.getStringFromFile(filePath)

        assert(logic.calculateFloor(string).equals(expected))
    }
}