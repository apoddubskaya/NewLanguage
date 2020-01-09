package com.example.newlanguage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        if (view is TextView) {
            startActivity(
                Intent(applicationContext, CategoryActivity::class.java).putExtra(
                    "categoryType",
                    view.text.toString()
                )
            )
        }
    }
}
