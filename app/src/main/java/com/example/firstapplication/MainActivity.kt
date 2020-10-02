package com.example.firstapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var REQUEST_KEY: Int = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnFirstActivity()
    }

    fun btnFirstActivity() {
        btn_first_activity.setOnClickListener {
            val textFirstActivity = editText.text.toString().trim()
            if (textFirstActivity.isNotEmpty()) {
                startActivityForResult(
                    Intent(this, SecondActivity::class.java).putExtra("key", textFirstActivity)
                    , REQUEST_KEY
                )
            } else {
                showToast(this, resources.getString(R.string.please_enter_text))
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_KEY && resultCode == RESULT_OK && data != null) {
            val newText = data.getStringExtra("key")
            text_view.text = newText
        }
    }
}