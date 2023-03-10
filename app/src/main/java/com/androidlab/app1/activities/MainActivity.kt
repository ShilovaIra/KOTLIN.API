package com.androidlab.app1.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.androidlab.app1.Constants.Constants
import com.androidlab.app1.Constants.Constants.Companion.LOGIN
import com.androidlab.app1.Constants.Constants.Companion.PASSWORD
import com.androidlab.app1.R

class MainActivity : AppCompatActivity() {

    private var login: EditText? = null
    private var password: EditText? = null
    private var loginButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login = findViewById(R.id.login)
        password = findViewById(R.id.passwrd)
        loginButton = findViewById(R.id.loginButton)

        loginButton!!.setOnClickListener {
            verifyCredentials(login!!.text.toString(), password!!.text.toString())
        }
    }

    private fun verifyCredentials(login: String, password: String) {
        if (PASSWORD.equals(password) && LOGIN.equals(login)) {
            val intent = Intent(this, BrewListActivity::class.java)
            startActivity(intent)
        }
        else {
            Toast.makeText(
                this@MainActivity,
                Constants.FAILED_LOGIN,
                Toast.LENGTH_LONG
            ).show()
        }
    }

}