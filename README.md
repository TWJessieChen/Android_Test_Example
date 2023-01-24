# Android TDD 相關測試方法範例

## TDD的三個步驟：
第一，先撰寫一個失敗的測試。（紅燈）
第二，撰寫剛好可以通過測試的產品程式碼。（綠燈）
第三，在不改變程式碼的外部行為下改進原始碼。（重構）在實務開發時，就是依循 TDD 的工作流程，依照需求完成一個又一個的單元測試。

在android TDD中，會先寫UI TDD測試，再寫UI底下Func的TDD相關測試。


## Android 的測試
1.實作 Local unit test
2.實作 Instrumented unit test
3.實作 UI test

Local unit test ：
Local unit test：只在Local 的機器上執行，這些測試在編譯後就在JVM(Java Virtual Machine)執行。這種單元測試不依賴於Android 框架，也就是不需要裝APK，執行的速度也快。在上個單元，我們所提到的測試都是屬於此類的單元測試。


Instrumented unit test：
Instrumented unit test 也是單元測試，只是需要Android裝置或模擬器上執行。
這些測試需要Android framework，像是Context等等。
執行的速度慢，因為你必須產生APK並安裝在裝置或模擬器上執行。
可以透過Mock Android framework，讓你仍是使用Local unit tests方式進行測試。


UI test：
UI 測試用來驗證使用者的操作行為，像點擊按鈕，輸入文字，基本上就是使用者會做的事，
當然一定要用到Android framework，因為你會直接接觸到UI，
也一定要安裝在Android裝置或模擬器。
這些UI測試，我們會使用Espresso來測試。

Local Unit Test 使用 Robolectric
Robolectric讓你可以用單元測試的方式來測試與Instrumented tests。

Instrumented tests 與 UI Test 的比較
這兩種測試都是寫在androidTest的目錄下，因為都是需要模擬器或實機。Instrumented 的中文的意思是「設備、儀器」指的就是在機器上的測試，跟UI Test的差異在於UI Test特別強制使用者的互動。例如你要測試儲存資料SharedPreferened就是Instrumented test。或是要測試Service的話，也是Instrumented test。

UI Test 與 Robolectric 的比較
我們在這個單元分別使用了UI測試：Espresso與Robolectric來測試View的行為，而這兩種有什麼差異呢？

UI測試的測試目錄在androidTest。
Robolectric的測試目錄在test。

UI測試在模擬器或實機測試。
Robolectric的測試在JVM測試。

UI測試失敗時，較慢找到失敗的原因。
Robolectric屬於單元測試，較快找到失敗的原因。

除了這兩個差異，更重要的是測試的行為是不一樣的。
在UI測試Espresso的測試註冊用驗證是否有「註冊成功」的字來確認。
而在Robolectric的測試註冊成功則是驗證Intent。


Local unit test 總是我們最優先考量的，因為效能最好，測試最穩定。如果有與Android framework相依的，可以使用Robolectric這個第三方元件，來模擬Android framework。也就是可以像Local unit tests一樣在JVM就可以執行。


這三種測試程式放在以下目錄：
app/src/main/java - Android 程式碼，通常會以Production code來稱像這樣的程式。
app/src/test/java - Local Unit tests，在JVM執行的單元測試。
app/src/androidTest/java - Instrumented unit tests 、UI 測試，需要在Android Device上執行




## 參考文章：
1.https://ithelp.ithome.com.tw/users/20111896/ironman/2181
2.https://tw.kotlin.tips/webinars/gfhxaa/test-driven-kotlin-for-android-development
3.https://www.youtube.com/watch?v=1h7dIbByhcs&t=96s
