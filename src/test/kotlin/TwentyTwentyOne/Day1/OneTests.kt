package TwentyTwentyOne.Day1

import org.junit.jupiter.api.Test

class oneTests{

    @Test
    fun getListFromFileTest(){
        val testLogic = aocLogicOneA()
        val filePath = "src/test/resources/TwentyTwentyOne/Inputs/Day1/OneTestInput"
        val correct = 10

        assert(testLogic.getListFromFile(filePath).size.equals(correct))
    }

    @Test
    fun calculateIncreaseInListTest(){
        val testLogic = aocLogicOneA()
        val filePath = "src/test/resources/TwentyTwentyOne/Inputs/Day1/OneTestInput"
        val correct = 7
        val list = testLogic.getListFromFile(filePath)

        assert(testLogic.calculateIncreaseInList(list).equals(correct))

    }

    @Test
    fun calculateIncreaseInListTestRevisited(){
        val testLogic = newAocOneAMain()
        val filePath = "src/test/resources/TwentyTwentyOne/Inputs/Day1/OneTestInput"
        val correct = 7
        val list = testLogic.getListFromFile(filePath)

        assert(testLogic.calculateIncreaseInList(list).equals(correct))
    }

    @Test
    fun compareIntsTest(){
        val testLogic = aocLogicOneB()
        val filePath = "src/test/resources/TwentyTwentyOne/Inputs/Day1/OneTestInput"
        val correct = 5

        assert(testLogic.calculateIncreaseInList(testLogic.getListFromFile(filePath)).equals(correct))
    }

    @Test
    fun compareIntsTestRevisited(){
        val testLogic = newAocLogicOneB()
        val filePath = "src/test/resources/TwentyTwentyOne/Inputs/Day1/OneTestInput"
        val correct = 5

        assert(testLogic.calculateIncreaseInList(testLogic.getListFromFile(filePath)).equals(correct))
    }
}