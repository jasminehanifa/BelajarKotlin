package com.example.intentsederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class IntentWithDataActivity : AppCompatActivity() {
    private lateinit var tvDataReceived: TextView

    companion object{
        const val EXTRA_AGE     = "age"
        const val EXTRA_NAME    = "name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_with_data)
        tvDataReceived = findViewById(R.id.tv_data_received)

        val name    = intent.getStringExtra(EXTRA_NAME)
        val age     = intent.getIntExtra(EXTRA_AGE, 0)
        val text    = "Name : $name, Your Age : $age"
        tvDataReceived.text = text
    }


}
