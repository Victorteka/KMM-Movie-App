package letsgodigital.africa.tmdbkmm

import letsgodigital.africa.tmdbkmm.utils.Greeting
import org.junit.Assert.assertTrue
import org.junit.Test

class AndroidGreetingTest {

    @Test
    fun testExample() {
        assertTrue("Check Android is mentioned", Greeting().greeting().contains("Android"))
    }
}