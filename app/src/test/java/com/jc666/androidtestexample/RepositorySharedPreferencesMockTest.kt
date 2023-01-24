package com.jc666.androidtestexample

import android.content.Context
import android.content.SharedPreferences
import com.jc666.androidtestexample.utils.Repository
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.*
import org.mockito.Mockito.`when`

/**
 *
 * RepositoryTest (Mock Android framework Test)
 *
 * 使用Mock套件
 * 來模擬測試android framework 相關API，形式上用Local unit tests，
 * 但就不需要額外藉由UI方式來測試，
 * 用套件來模擬。
 *
 * CSDN :
 * Mock 测试就是在测试过程中，
 * 对于某些不容易构造（如 HttpServletRequest 必须在Servlet 容器中才能构造出来）
 * 或者不容易获取的对象（如 JDBC 中的ResultSet 对象,JPA的CRUDRepository,需要执行数据库操作的），
 * 用一个虚拟的对象（Mock 对象）来创建（覆盖方法返回）以便测试的测试方法。
 * JUnit 是一个单元测试框架。
 * Mockito 是用于数据模拟对象的框架。
 *
 * @author JC666
 */

class RepositorySharedPreferencesMockTest {

    @Test
    fun saveUserId() {
        val sharedPrefs = mock(SharedPreferences::class.java)
        val sharedPrefsEditor = mock(SharedPreferences.Editor::class.java)
        val context = mock(Context::class.java)

        //使用when().thenReturn()，來測試SharedPreferences是否可以正常輸入以及取出
        `when`(context.getSharedPreferences(anyString(), anyInt())).thenReturn(sharedPrefs)
        `when`(sharedPrefs.edit()).thenReturn(sharedPrefsEditor)
        `when`(sharedPrefsEditor.putString(anyString(), anyString())).thenReturn(sharedPrefsEditor)

        val userId = "A1234567"
        val preKey = "USER_DATA"

        //執行被測試物件：Act 呼叫repository.saveUserId()
        val repository = Repository(context)
        repository.saveUserId(userId)

        //Assert
        //檢查是否有putString，及傳入的key、value是否正確
        verify(sharedPrefsEditor).putString(
            argThat { key -> key == preKey },
            argThat { value -> value == userId }
        )

        //檢查SharedPreference是否有呼叫commit
        verify(sharedPrefsEditor).commit()
    }
}