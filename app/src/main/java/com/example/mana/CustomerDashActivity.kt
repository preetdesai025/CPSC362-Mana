package com.example.mana

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.dashboard.*

class CustomerDashActivity : AppCompatActivity () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)

        safety_text.setOnClickListener {
            val intent = Intent(this, GuidelineActivity::class.java)
            startActivity(intent)
        }

        safety_icon.setOnClickListener {
            val intent = Intent(this, GuidelineActivity::class.java)
            startActivity(intent)
        }

        account_icon.setOnClickListener {
            val intent = Intent(this, AccountActivity::class.java)
            startActivity(intent)
        }

        selectRestaurant_text.setOnClickListener {
            val intent = Intent(this, RestaurantActivity::class.java)
            startActivity(intent)
        }
    }
}