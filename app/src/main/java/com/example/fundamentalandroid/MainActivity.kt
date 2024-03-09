package com.example.fundamentalandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fundamentalandroid.databinding.ActivityMainBinding
import com.example.fundamentalandroid.learnappbar.MainActivityAppBar
import com.example.fundamentalandroid.learnfragment.FlexibleFragment
import com.example.fundamentalandroid.learnnavigation.MainNavigation
import com.example.fundamentalandroid.learntablayout.MainActivityTabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with(binding) {
            buttonMoveToLearnFragment.setOnClickListener {
                val btnMoveToLearnFragment = Intent(this@MainActivity, FlexibleFragment::class.java)
                startActivity(btnMoveToLearnFragment)
            }
            buttonMoveToLearnNavigation.setOnClickListener {
                val btnMoveToLearnNavigation = Intent(this@MainActivity, MainNavigation::class.java)
                startActivity(btnMoveToLearnNavigation)
            }
            buttonMoveToLearnAppBar.setOnClickListener {
                startActivity(Intent(this@MainActivity, MainActivityAppBar::class.java))
            }

            buttonMoveToLearnTabLayoutViewPager2.setOnClickListener {
                startActivity(Intent(this@MainActivity, MainActivityTabLayout::class.java))
            }
        }
    }

}