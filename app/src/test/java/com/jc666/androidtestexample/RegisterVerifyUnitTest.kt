package com.jc666.androidtestexample

import com.jc666.androidtestexample.utils.RegisterVerify
import org.junit.Test

import org.junit.Assert.*

/**
 *
 * Register Verify (Unit Test)
 * 針對註冊帳號ID字串比對func進行測試項目
 *
 * @author JC666
 */

class RegisterVerifyUnitTest {

    @Test
    fun loginVerifyTrue() {
        val registerVerify = RegisterVerify()
        assertTrue(registerVerify.isLoginIdVerify("A123456"))
    }

    @Test
    fun loginVerifyFalse() {
        val registerVerify = RegisterVerify()
        assertFalse(registerVerify.isLoginIdVerify("A1234"))
    }
}