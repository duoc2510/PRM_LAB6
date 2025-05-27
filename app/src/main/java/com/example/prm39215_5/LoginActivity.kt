package com.example.prm39215_5


import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val emailField = findViewById<EditText>(R.id.edtEmail)
        val passwordField = findViewById<EditText>(R.id.edtPassword)
        val loginButton = findViewById<Button>(R.id.btnLogin)
        val registerLink = findViewById<TextView>(R.id.txtCreateAccount)
        val userField = findViewById<EditText>(R.id.edtUsername)

        loginButton.setOnClickListener {
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()
            val username = userField.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập email và mật khẩu", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (email == "admin" && password == "123456") {
                Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, PRM329_27_5::class.java)
                intent.putExtra("USERNAME_KEY", username) // 👈 đúng thứ tự
                startActivity(intent)
                finish()
            }
            else
            {
                Toast.makeText(this, "Login fail", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }

        }
    }
}

