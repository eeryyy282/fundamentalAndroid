package com.example.fundamentalandroid.learnviewmodel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.fundamentalandroid.R
import com.example.fundamentalandroid.databinding.ActivityMainViewModelBinding

class MainActivityViewModel : AppCompatActivity() {

    private lateinit var activityMainViewModelBinding: ActivityMainViewModelBinding
//    private lateinit var viewModel: MainViewModel
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainViewModelBinding = ActivityMainViewModelBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(activityMainViewModelBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        displayResult()

        activityMainViewModelBinding.btnCalculate.setOnClickListener {
            val width = activityMainViewModelBinding.edtWidth.text.toString()
            val height = activityMainViewModelBinding.edtHeight.text.toString()
            val length = activityMainViewModelBinding.edtLength.text.toString()

            when {
                width.isEmpty() -> {
                    activityMainViewModelBinding.edtWidth.error = "Masih Kosong"
                }
                height.isEmpty() -> {
                    activityMainViewModelBinding.edtHeight.error = "Masih Kosong"
                }
                length.isEmpty() -> {
                    activityMainViewModelBinding.edtLength.error = "Masih Kosong"
                }
                else -> {
                    viewModel.calculate(width, height, length)
                    displayResult()
                }
            }
        }
    }

    private fun displayResult() {
        activityMainViewModelBinding.tvResult.text = viewModel.result.toString()
    }
}