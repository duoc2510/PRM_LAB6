package com.example.prm39215_5


import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class Lab4 : AppCompatActivity() {
    private lateinit var container: FrameLayout
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        container = findViewById(R.id.container)
        bottomNav = findViewById(R.id.bottomNavigationView) // lấy từ <include>

        showHomeContent() // hiển thị mặc định

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
        container.removeAllViews()
        val textView = TextView(this).apply {
            text = "Chào mừng bạn đến với Trang chủ"
            textSize = 20f
            gravity = Gravity.CENTER
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
        }
        container.addView(textView)
    }

    private fun showSearchContent() {
        container.removeAllViews()
        val textView = TextView(this).apply {
            text = "Tìm kiếm nội dung..."
            textSize = 20f
            gravity = Gravity.CENTER
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
        }
        container.addView(textView)
    }

    private fun showProfileContent() {
        container.removeAllViews()
        val textView = TextView(this).apply {
            text = "Thông tin tài khoản của bạn"
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

