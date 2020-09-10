package com.example.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mEditText: EditText? = null
    private var mData: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("onCreate invoked")
        mEditText = findViewById(R.id.editText)
        mEditText?.setText(this.mData)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("myData", mEditText?.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        mEditText?.setText(savedInstanceState.getString("myData"))
    }

    fun gotoActivity(view: View) {
        val intent = Intent(applicationContext, SecondActivity::class.java)
        val text = editText.text.toString()
        intent.putExtra("EditText Value", text)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        println("onStart invoked")
    }

    override fun onResume() {
        super.onResume()
        println("onResume invoked")
    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart invoked")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy invoked")
    }

    override fun onPause() {
        super.onPause()
        mData = mEditText?.text.toString()
        println("onPause invoked")
    }

    override fun onStop() {
        super.onStop()
        println("onStop invoked")
    }
}