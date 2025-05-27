package com.example.prm39215_5

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DialerActivityLab6 : AppCompatActivity() {

    private lateinit var display: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialer_lab6)

        display = findViewById(R.id.number_display)

        val buttons = listOf(
            R.id.btn0 to "0", R.id.btn1 to "1", R.id.btn2 to "2", R.id.btn3 to "3",
            R.id.btn4 to "4", R.id.btn5 to "5", R.id.btn6 to "6",
            R.id.btn7 to "7", R.id.btn8 to "8", R.id.btn9 to "9",
            R.id.btn_star to "*"
        )

        buttons.forEach { (id, value) ->
            findViewById<Button>(id).setOnClickListener {
                display.append(value)
            }
        }

        findViewById<Button>(R.id.btn_clear).setOnClickListener {
            display.text = ""
        }
    }
}