package com.jc666.androidtestexample


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.jc666.androidtestexample.utils.RegisterVerify
import com.jc666.androidtestexample.utils.Repository

class MainActivity : AppCompatActivity() {

    var et_loginId : EditText? = null
    var et_password : EditText? = null
    var btn_send : Button? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_loginId = findViewById(R.id.et_loginId)
        et_password = findViewById(R.id.et_password)
        btn_send = findViewById(R.id.btn_send)

        btn_send!!.setOnClickListener {
            val loginId = et_loginId!!.text.toString()
            val pwd = et_password!!.text.toString()

            //檢核帳號是否正確
            val isLoginIdOK = RegisterVerify().isLoginIdVerify(loginId)

            //檢核密碼是否正確
            val isPwdOK = RegisterVerify().isPasswordVerify(pwd)

            val builder = AlertDialog.Builder(this)

            if (!isLoginIdOK) {
                // 註冊失敗，資料填寫錯誤
                builder.setMessage("帳號至少要6碼，第1碼為英文").setTitle("錯誤")
                builder.show()

            } else if (!isPwdOK) {
                builder.setMessage("密碼至少要8碼，第1碼為英文，並包含1碼數字").setTitle("錯誤")
                builder.show()
            } else {
                //註冊成功，儲存Id
                Repository(this).saveUserId(loginId)

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("ID", loginId)

                startActivity(intent)
            }
        }

    }
}