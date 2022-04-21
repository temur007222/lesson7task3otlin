package com.example.lesson7task3otlin

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var loginButton: Button
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = findViewById(R.id.username_text)
        password = findViewById(R.id.password_text)
        loginButton = findViewById(R.id.login_button)
        textView = findViewById(R.id.textView)

        username.setOnKeyListener(View.OnKeyListener { view, i, keyEvent ->
            textView.text = username.text.toString()
            false
        })

        loginButton.isEnabled

        val textWatcher: TextWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                val userNameText: String = this@MainActivity.username.text.toString()
                val passwordText = password.text.toString()
                loginButton.isEnabled =
                    !userNameText.contentEquals("") && !passwordText.contentEquals("")
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        }
        username.addTextChangedListener(textWatcher)
        password.addTextChangedListener(textWatcher)
      }
    }