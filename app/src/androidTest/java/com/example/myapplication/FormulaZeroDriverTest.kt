package com.example.myapplication

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormulaZeroDriverTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun navigate_to_formulaZeroDriver_add_driver_clear_driver_and_return_home()
    {
        composeTestRule
            .onNodeWithTag("driverButton")
            .performClick()

        composeTestRule
            .onNodeWithTag("NameInput")
            .performTextInput("Minion1")

        composeTestRule
            .onNodeWithText("Minion1")
            .assertExists()


        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        composeTestRule
            .onNodeWithTag("NameInput")
            .performTextInput("Minion2")


        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        composeTestRule
            .onNodeWithText("Minion2")
            .assertExists()

        composeTestRule
            .onNodeWithTag("clearDriverButton")
            .performClick()

        composeTestRule
            .onNodeWithText("Minion2")
            .assertDoesNotExist()

        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }

}