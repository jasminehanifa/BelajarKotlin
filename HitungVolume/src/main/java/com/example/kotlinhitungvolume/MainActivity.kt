package com.example.kotlinhitungvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_calculate.setOnClickListener(this)

        if (savedInstanceState != null){
            val result = savedInstanceState.getString(STATE) as String
            tv_result.text = result
        }

    }

    companion object{
        private const val STATE = "state"
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE, tv_result.text.toString())
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_calculate){
            val inputLength = edt_length.text.toString().trim()
            val inputWidth  = edt_width.text.toString().trim()
            val inputHeight = edt_height.text.toString().trim()
            var isEmpty     = false

            if (inputLength.isEmpty()){
                isEmpty = true
                edt_length.error = "Length tidak boleh kosong"
            }

            if (inputHeight.isEmpty()){
                isEmpty = true
                edt_height.error = "Height tidak boleh kosong"
            }

            if (inputWidth.isEmpty()){
                isEmpty = true
                edt_width.error = "Width tidak boleh kosong"
            }

            if (!isEmpty){
                val volume      = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                tv_result.text   = volume.toString()
            }
        }
    }

}
