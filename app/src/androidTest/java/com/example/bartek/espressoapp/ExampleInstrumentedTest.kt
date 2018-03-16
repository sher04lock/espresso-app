package com.example.bartek.espressoapp

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import android.support.test.rule.ActivityTestRule
import org.junit.Rule



/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule @JvmField
    val mActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.example.bartek.espressoapp", appContext.packageName)
    }

    @Test
    fun mainActivitySaysHello() {
        val testName = "Bartek"
        onView(withId(R.id.editText)).perform(ViewActions.clearText())
        onView(withId(R.id.editText)).perform(ViewActions.typeText(testName))
        onView(withId(R.id.button)).perform(ViewActions.click())
        onView(withId(R.id.hello_text)).check(matches(withText(testName)))
    }
}
