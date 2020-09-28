package com.example.firstapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    lateinit var text: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        showTextFirstActivity()
    }

    private fun showTextFirstActivity() {
        val getText = intent
        text = getText.getStringExtra("key") as String
        editText2.setText(text)
    }

    fun onSendBack(view: View) {
        val newText = editText2.text.toString().trim()
        if (newText.isNotEmpty()) {
            intent.putExtra("key", newText)
            setResult(RESULT_OK, intent)
            finish()
        }
    }

}