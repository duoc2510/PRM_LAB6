package com.example.prm39215_5

import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class PRM329_27_5 : AppCompatActivity() {
    private lateinit var container: FrameLayout
    private lateinit var bottomNav: BottomNavigationView
    private var username: String = "Unknown"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        container = findViewById(R.id.container)
        bottomNav = findViewById(R.id.bottomNavigationView)

        val txtUsername = findViewById<TextView>(R.id.txtUsername)
        username = intent.getStringExtra("USERNAME_KEY") ?: "Unknown"
        txtUsername.text = "Xin chào, $username!"

        showHomeContent()

        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> showHomeContent()
                R.id.nav_search -> showSearchContent()
                R.id.nav_profile -> showProfileContent()
            }
            true
        }
    }

    private fun showHomeContent() {
        username = intent.getStringExtra("USERNAME_KEY") ?: "Unknown"

        showCenteredText("Chào mừng $username đến với Trang chủ")
    }

    private fun showSearchContent() {
        showCenteredText("Tìm kiếm nội dung...")
    }

    private fun showProfileContent() {
        showCenteredText("Thông tin tài khoản của bạn:\n$username")
    }

    // Hàm dùng chung để tạo TextView căn giữa
    private fun showCenteredText(content: String) {
        container.removeAllViews()
        val textView = TextView(this).apply {
            text = content
            textSize = 20f
            gravity = Gravity.CENTER
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
        }
        container.addView(textView)
    }
}
