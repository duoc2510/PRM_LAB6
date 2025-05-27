package com.example.prm39215_5


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val received = intent?.getLongExtra("new_value", -10L)?.plus(10)
        Toast.makeText(context, "Giá trị nhận được là: $received", Toast.LENGTH_LONG).show()
    }
}