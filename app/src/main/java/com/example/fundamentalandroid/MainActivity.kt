package com.example.fundamentalandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fundamentalandroid.learnappbar.MainActivityAppBar
import com.example.fundamentalandroid.learnfragment.FlexibleFragment
import com.example.fundamentalandroid.learnnavigation.MainNavigation

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnMoveToLearnFragment: Button = findViewById(R.id.buttonMoveToLearnFragment)
        btnMoveToLearnFragment.setOnClickListener(this)

        val btnMoveToLearnNavigation: Button = findViewById(R.id.buttonMoveToLearnNavigation)
        btnMoveToLearnNavigation.setOnClickListener(this)

        val btnMoveToLearnAppBar: Button = findViewById(R.id.buttonMoveToLearnAppBar)
        btnMoveToLearnAppBar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.buttonMoveToLearnFragment -> {
                val moveToLearnFragment = Intent(this@MainActivity, FlexibleFragment::class.java)
                startActivity(moveToLearnFragment)
            }

            R.id.buttonMoveToLearnNavigation -> {
                val moveToLearnNavigation = Intent(this@MainActivity, MainNavigation::class.java)
                startActivity(moveToLearnNavigation)
            }
            R.id.buttonMoveToLearnAppBar -> {
                val moveToLearnAppBar = Intent(this@MainActivity, MainActivityAppBar::class.java)
                startActivity(moveToLearnAppBar)
            }
        }

    }
}