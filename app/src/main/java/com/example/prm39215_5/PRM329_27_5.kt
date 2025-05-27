package com.example.prm39215_5

import android.content.Intent
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
        container.removeAllViews()

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
            setPadding(32, 32, 32, 32)
        }

        val textView = TextView(this).apply {
            text = "Chào mừng $username đến với Trang chủ"
            textSize = 20f
            gravity = Gravity.CENTER
        }

        val btnToLogin = Button(this).apply {
            text = "Đăng xuất"
            setOnClickListener {
                val intent = Intent(this@PRM329_27_5, LoginActivity::class.java)
                startActivity(intent)
                finish() // Quan trọng: kết thúc Activity hiện tại để không quay lại khi Back
            }
        }


        val btnToDialer = Button(this).apply {
            text = "Mở bàn phím quay số"
            setOnClickListener {
                val intent = Intent(this@PRM329_27_5, DialerActivityLab6::class.java)
                startActivity(intent)
            }
        }
        val btnToActivity1 = Button(this).apply {
            text = "Mở nhập số"
            setOnClickListener {
                val intent = Intent(this@PRM329_27_5, MainActivityLab6::class.java)
                startActivity(intent)
            }
        }

        layout.addView(textView)
        layout.addView(btnToLogin)
        layout.addView(btnToDialer)
        layout.addView(btnToActivity1)


        container.addView(layout)
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
