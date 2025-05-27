package com.example.prm39215_5



import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivityLab6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_lab6)

        val editValue = findViewById<EditText>(R.id.editValue)
        val btnSend = findViewById<Button>(R.id.btnSend)

        btnSend.setOnClickListener {
            val value = editValue.text.toString().toLongOrNull() ?: 0L
            val intent = Intent(this, SecondaryActivityLab6::class.java)
            intent.putExtra("value", value)
            startActivity(intent)
        }
    }
}