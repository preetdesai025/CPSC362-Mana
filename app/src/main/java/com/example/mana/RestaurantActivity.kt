package com.example.mana

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.restaurant_select.*

class RestaurantActivity : AppCompatActivity () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.restaurant_select)

        val listView = findViewById<ListView>(R.id.restaurant_listView)
        listView.adapter = RestaurantAdapter(this)
    }

    private class RestaurantAdapter(context: Context): BaseAdapter() {
        private val mContext: Context

        init {
            mContext = context
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup): View {
            val textView = TextView(mContext)
            textView.text = "Rows to display restaurants"
            return textView
        }

        override fun getItem(position: Int): Any {
            return "TEST STRING"
        }

        override fun getItemId(position: Int): Long {
           return position.toLong()
        }

        // Rows in list
        override fun getCount(): Int {
            return 5
        }

    }
}