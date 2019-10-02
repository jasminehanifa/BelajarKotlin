package com.example.kotlinhitungvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etWidth: EditText
    private lateinit var etHeight: EditText
    private lateinit var etLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etWidth         = findViewById(R.id.edt_width)
        etHeight        = findViewById(R.id.edt_height)
        etLength        = findViewById(R.id.edt_length)
        btnCalculate    = findViewById(R.id.btn_calculate)
        tvResult        = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)

        if (savedInstanceState != null){
            val result = savedInstanceState.getString(STATE) as String
            tvResult.text = result
        }

    }

    companion object{
        private const val STATE = "state"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE, tvResult.text.toString())
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_calculate){
            val inputLength = etLength.text.toString().trim()
            val inputWidth  = etWidth.text.toString().trim()
            val inputHeight = etHeight.text.toString().trim()
            var isEmpty     = false

            if (inputLength.isEmpty()){
                isEmpty = true
                etLength.error = "Length tidak boleh kosong"
            }

            if (inputHeight.isEmpty()){
                isEmpty = true
                etHeight.error = "Height tidak boleh kosong"
            }

            if (inputWidth.isEmpty()){
                isEmpty = true
                etWidth.error = "Width tidak boleh kosong"
            }

            if (!isEmpty){
                val volume      = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                tvResult.text   = volume.toString()
            }
        }
    }

}
