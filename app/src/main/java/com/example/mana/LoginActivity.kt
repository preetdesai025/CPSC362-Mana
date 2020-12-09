package com.example.mana

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.login.*

class LoginActivity : AppCompatActivity () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        login_button.setOnClickListener {
            val intent = Intent(this, CustomerDashActivity::class.java)
            startActivity(intent)
        }
    }
}