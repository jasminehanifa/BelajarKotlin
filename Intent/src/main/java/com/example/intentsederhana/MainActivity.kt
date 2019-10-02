package com.example.intentsederhana

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.intentsederhana.Inetnt.IntentActivity
import com.example.intentsederhana.Inetnt.IntentParcelable
import com.example.intentsederhana.Inetnt.IntentWithDataActivity
import com.example.intentsederhana.Inetnt.MoveForResultActivity
import com.example.intentsederhana.Model.PersonData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnIntent: Button
    private lateinit var btnIntentData: Button
    private lateinit var btnIntentParcel: Button
    private lateinit var btnDialNumber: Button
    private lateinit var btnIntentWithResult: Button
    private lateinit var tvResultActivity: TextView

    companion object{
        private const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIntent           = findViewById(R.id.btn_move_activity)
        btnIntentData       = findViewById(R.id.btn_move_data)
        btnIntentParcel     = findViewById(R.id.btn_move_activity_object)
        btnDialNumber       = findViewById(R.id.btn_dial_number)
        btnIntentWithResult = findViewById(R.id.btn_move_for_result)

        tvResultActivity = findViewById(R.id.tv_result)

        btnIntent.setOnClickListener(this)
        btnIntentData.setOnClickListener(this)
        btnIntentParcel.setOnClickListener(this)
        btnDialNumber.setOnClickListener(this)
        btnIntentWithResult.setOnClickListener(this)

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
                val PersonData = PersonData(
                    "Kotlin Developer",
                    5,
                    "jasonjiu@yahoo.com",
                    "jakarta"
                )

                val intentParcelable = Intent(this@MainActivity, IntentParcelable::class.java)
                intentParcelable.putExtra(IntentParcelable.EXTRA_DATA, PersonData)
                startActivity(intentParcelable)
            }

            R.id.btn_dial_number->{
                val phoneNumber = "081354699473"
                val dialPhoneintent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneintent)
            }
            R.id.btn_move_for_result->{
                val intent = Intent(this@MainActivity, MoveForResultActivity::class.java)
               startActivityForResult(intent, REQUEST_CODE)
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE){
            if (resultCode == MoveForResultActivity.RESULT_CODE){
                val selectedValue = data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
                tv_result.text = "Hasil : $selectedValue"
            }
        }
    }

}
