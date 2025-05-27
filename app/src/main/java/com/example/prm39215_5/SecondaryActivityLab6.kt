package com.example.prm39215_5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SecondaryActivityLab6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_lab6)

        val value = intent.getLongExtra("value", 0L)
        val editReceived = findViewById<EditText>(R.id.editReceived)
        val btnBroadcast = findViewById<Button>(R.id.btnBroadcast)

        editReceived.setText(value.toString())

        btnBroadcast.setOnClickListener {
            val broadcastIntent = Intent(this, MyBroadcastReceiver::class.java)
            broadcastIntent.putExtra("new_value", value - 10)
            sendBroadcast(broadcastIntent)
        }
    }
}