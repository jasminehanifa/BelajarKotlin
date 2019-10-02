package com.example.intentsederhana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnIntent: Button
    private lateinit var btnIntentData: Button
    private lateinit var btnIntentParcel: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIntent       = findViewById(R.id.btn_move_activity)
        btnIntentData   = findViewById(R.id.btn_move_data)
        btnIntentParcel = findViewById(R.id.btn_move_activity_object)
        btnIntent.setOnClickListener(this)
        btnIntentData.setOnClickListener(this)
        btnIntentParcel.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_move_activity ->{
                val intent = Intent(this@MainActivity, IntentActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_move_data->{
                val intentWithData = Intent(this@MainActivity, IntentWithDataActivity::class.java)
                intentWithData.putExtra(IntentWithDataActivity.EXTRA_NAME, "Jason")
                intentWithData.putExtra(IntentWithDataActivity.EXTRA_AGE, 22)
                startActivity(intentWithData)
            }
            R.id.btn_move_activity_object->{
                val PersonData = PersonData("Kotlin Developer", 5, "jasonjiu@yahoo.com", "jakarta")
                val intentParcelable = Intent(this@MainActivity, IntentParcelable::class.java)
                intentParcelable.putExtra(IntentParcelable.EXTRA_DATA, PersonData)
                startActivity(intentParcelable)
            }
        }

    }

}
