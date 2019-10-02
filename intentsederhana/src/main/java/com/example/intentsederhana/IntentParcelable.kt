package com.example.intentsederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class IntentParcelable : AppCompatActivity() {
    private lateinit var tvObj: TextView

    companion object{
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_parcelable)

        tvObj = findViewById(R.id.tv_object_received)
        val personData  = intent.getParcelableExtra(EXTRA_DATA) as PersonData
        val text        = "Name : ${personData.name.toString()}," +
                        " \nEmail : ${personData.email.toString()}," +
                        " \nAge : ${personData.age.toString()}, " +
                        "\nLocation : ${personData.city.toString()}"

        tvObj.text = text

    }
}
