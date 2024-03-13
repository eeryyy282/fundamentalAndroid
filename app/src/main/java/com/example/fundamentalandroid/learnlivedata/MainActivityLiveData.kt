package com.example.fundamentalandroid.learnlivedata

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.fundamentalandroid.R
import com.example.fundamentalandroid.databinding.ActivityMainLiveDataBinding

class MainActivityLiveData : AppCompatActivity() {

    private lateinit var liveDataTimerViewModel: MainViewModelLiveData
    private lateinit var activityLiveDataMainBinding: ActivityMainLiveDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityLiveDataMainBinding = ActivityMainLiveDataBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(activityLiveDataMainBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        liveDataTimerViewModel = ViewModelProvider(this)[MainViewModelLiveData::class.java]
        subscribe()
    }

    private fun subscribe() {
        val elapsedTimeObserver = Observer<Long?> { aLong ->
            val newText = this@MainActivityLiveData.resources.getString(R.string.seconds, aLong)
            activityLiveDataMainBinding.timerTextview.text = newText
        }

        liveDataTimerViewModel.getElapsedTime().observe(this, elapsedTimeObserver)
    }
}