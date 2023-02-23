package TwentyTwentyOne.Day2

import org.junit.jupiter.api.Test
import kotlin.math.log

class TwoTests {

     @Test
     fun calculateSubmarineMovementTest(){
         val logic = aocTwoAMain()
         val correct1 = "distance 15"
         val correct2 = "depth 10"
         val fileInput = "src/test/resources/TwentyTwentyOne/Inputs/Day2/TwoTestInput"

         assert(logic.calculateSubmarineMovement(logic.getListFromFile(fileInput)).get(0).equals(correct1))
         assert(logic.calculateSubmarineMovement(logic.getListFromFile(fileInput)).get(1).equals(correct2))

     }

    @Test
    fun calculateTotalTraveledTest(){
        val logic = aocTwoAMain()
        val correct = 150
        val fileInput = "src/test/resources/TwentyTwentyOne/Inputs/Day2/TwoTestInput"

        assert(logic.calculateTotalTraveled(logic.calculateSubmarineMovement(logic.getListFromFile(fileInput))).equals(correct))
    }

    @Test
    fun calculateSubmarineMovementRevisitedTest(){
        val logic = newAocTwoAMain()
        val correct1 = "distance 15"
        val correct2 = "depth 10"
        val fileInput = "src/test/resources/TwentyTwentyOne/Inputs/Day2/TwoTestInput"

        assert(logic.calculateSubmarineMovement(logic.getListFromFile(fileInput)).get(0).equals(correct1))
        assert(logic.calculateSubmarineMovement(logic.getListFromFile(fileInput)).get(1).equals(correct2))

    }

    @Test
    fun calculateTotalTraveledRevisitedTest(){
        val logic = newAocTwoAMain()
        val correct = 150
        val fileInput = "src/test/resources/TwentyTwentyOne/Inputs/Day2/TwoTestInput"

        assert(logic.calculateTotalTraveled(logic.calculateSubmarineMovement(logic.getListFromFile(fileInput))).equals(correct))
    }

    @Test
    fun calculateSubmarineMovementWithAimTest(){
        val logic = aocTwoBMain()
        val correct1 = "distance 15"
        val correct2 = "depth 60"
        val fileInput = "src/test/resources/TwentyTwentyOne/Inputs/Day2/TwoTestInput"

        assert(logic.calculateSubmarineMovement(logic.getListFromFile(fileInput)).get(0).equals(correct1))
        assert(logic.calculateSubmarineMovement(logic.getListFromFile(fileInput)).get(1).equals(correct2))

    }

    @Test
    fun calculateTotalTraveledWithAimTest(){
        val logic = aocTwoBMain()
        val correct = 900
        val fileInput = "src/test/resources/TwentyTwentyOne/Inputs/Day2/TwoTestInput"

        assert(logic.calculateTotalTraveled(logic.calculateSubmarineMovement(logic.getListFromFile(fileInput))).equals(correct))
    }

}