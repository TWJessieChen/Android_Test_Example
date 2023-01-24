package com.jc666.androidtestexample

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.jc666.androidtestexample.utils.ISharePreferenceManager
import com.jc666.androidtestexample.utils.SharedPreferenceManager
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

/**
 * SharedPreferenceManagerTest (需要模擬器來進行測試)
 *
 * 把所有跟Android framework的相依都用Mock去模擬及隔離，有時不見得是好的選擇。
 * 因為你不會知道在Android裝置上是不是真的可以執行。
 *
 * Instrumented test：
 * 測試SharePreference是否有儲存成功。
 *
 * 注意一點!!!
 * 不是遇到Android framework，就一定是用mock來處理。
 *
 * 在Repository我們保留Local Unit test來提高測試的效率(範例程式 : RepositoryTest)。
 * 在SharedPreferenceManager，這裡就直接使用Instrumented test，較接近真實的情況。
 *
 */
@RunWith(AndroidJUnit4::class)
class SharedPreferenceManagerTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        val key = "User_Id"
        val value = "A123456789"

        val sharedPreferenceManager: ISharePreferenceManager = SharedPreferenceManager(appContext)
        sharedPreferenceManager.saveString(key, value)

        val valueFromSP = sharedPreferenceManager.getString(key)

        //將SharedPreference取出，驗證結果
        Assert.assertEquals(value, valueFromSP)

    }
}
