package com.jc666.androidtestexample

import com.jc666.androidtestexample.utils.ISharePreferenceManager
import com.jc666.androidtestexample.utils.Repository
import com.jc666.androidtestexample.utils.RepositoryInterface
import org.junit.Test
import org.mockito.Mockito.*

/**
 *
 * RepositoryTest (Unit Test)
 *
 * Local Unit test：
 * 測試Repository.saveUserId 與 ISharedPreferenceManager的互動
 *
 *
 * @author JC666
 */

class RepositoryTest {

    @Test
    fun saveUserId() {

        val mockSharedPreferenceManager = mock(ISharePreferenceManager::class.java)

        val userId = "A1234567"
        val preKey = "USER_ID"

        val repository = RepositoryInterface(mockSharedPreferenceManager)

        //Act 呼叫repository.saveUserId()
        repository.saveUserId(userId)

        //Assert
        verify(mockSharedPreferenceManager).saveString(preKey, userId)
    }
}