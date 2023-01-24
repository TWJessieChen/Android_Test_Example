package com.jc666.androidtestexample

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test

/**
 *
 * RegisterTest (UI Test)
 *
 * UI 測試：使用Espresso套件
 * 針對頁面上輸入文字結果進行驗證流程
 *
 * @author JC666
 */

@LargeTest
class RegisterUITest {

//    @Before
//    fun launchActivity() {
//        ActivityScenario.launch(MainActivity::class.java)
//    }

    @get:Rule
    @JvmField
    var activityActivityTestRule = ActivityScenario.launch(MainActivity::class.java)

    @Test
    fun rightPassword_should_startActivity() {

        //輸入正確的帳密
        inputRightRegisterData()

        //點選註冊按鈕
        onView(withId(R.id.btn_send)).perform(click())

        //註冊成功，導至成功頁。
        onView(withText("註冊成功")).check(matches(isDisplayed()))
    }

    private fun inputRightRegisterData() {
        //輸入帳號
        onView(withId(R.id.et_loginId)).perform(typeText("a123456789"), ViewActions.closeSoftKeyboard())
        //輸入密碼
        onView(withId(R.id.et_password)).perform(typeText("a111111111"), ViewActions.closeSoftKeyboard())
    }

    @Test
    fun wrongPassword_should_alert() {

        inputWrongRegisterData()

        //點選註冊按鈕
        onView(withId(R.id.btn_send)).perform(click())

        //註冊失敗，Alert
        onView(withText("錯誤"))
            .inRoot(isDialog())
            .check(matches(isDisplayed()))

    }

    private fun inputWrongRegisterData() {
        //輸入帳號
        onView(withId(R.id.et_loginId)).perform(typeText("a123456789"), ViewActions.closeSoftKeyboard())

        //輸入密碼
        onView(withId(R.id.et_password)).perform(typeText("1234"), ViewActions.closeSoftKeyboard())
    }
}