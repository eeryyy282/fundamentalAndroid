package com.example.fundamentalandroid.learnappbar

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fundamentalandroid.R
import com.example.fundamentalandroid.databinding.ActivityMainAppBarBinding
import com.example.fundamentalandroid.learnappbar.fragment.MenuFragmentAppBar

class MainActivityAppBar : AppCompatActivity() {

    private lateinit var binding: ActivityMainAppBarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainAppBarBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu1 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, MenuFragmentAppBar())
                        .addToBackStack(null)
                        .commit()
                    true
                }

                R.id.menu2 -> {
                    val intent = Intent(this, MenuActivityAppBar::class.java)
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }
    }
}