package Tomtar

import Tomtar.Logic
import org.junit.   jupiter.api.Test
import java.util.Locale

class LogicTests1 {

    @Test
    fun skapaChefmapTest1(){
        val testLogic = Logic()
        val testMap = testLogic.skapaChefMap()
        val actual = 7

        assert(testMap.size.equals(actual))
    }

    @Test
    fun skapaChefmapTest2(){
        val testLogic = Logic()
        val testMap = testLogic.skapaChefMap()
        val actual = "Butter"

        assert(testMap.containsKey(actual))
    }
    @Test
    fun hämtaTomteTest(){
        val testLogic = Logic()
        val string = "Tomten"
        val actual = testLogic.hämtaTomte(string, testLogic.skapaChefMap(), mutableListOf()).get(0)
        val expect = "Glader"
        assert(actual.equals(expect))
    }



}

