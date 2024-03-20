package com.example.fundamentalandroid.learntest

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fundamentalandroid.R
import com.example.fundamentalandroid.databinding.ActivityMainTestBinding

class MainActivityTest : AppCompatActivity(), View.OnClickListener {

    private lateinit var activityMainTestBinding: ActivityMainTestBinding
    private lateinit var mainViewModelTest: MainViewModelTest
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainTestBinding = ActivityMainTestBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(activityMainTestBinding.root)

        mainViewModelTest = MainViewModelTest(CuboidModel())

        activityMainTestBinding.btnSave.setOnClickListener(this)
        activityMainTestBinding.btnCalculateSurfaceArea.setOnClickListener(this)
        activityMainTestBinding.btnCalculateCircumference.setOnClickListener(this)
        activityMainTestBinding.btnCalculateVolume.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        val length = activityMainTestBinding.edtLength.text.toString().trim()
        val width = activityMainTestBinding.edtWidth.text.toString().trim()
        val height = activityMainTestBinding.edtHeight.text.toString().trim()

        when {
            TextUtils.isEmpty(length) -> {
                activityMainTestBinding.edtLength.error = "Field ini tidak boleh kosong"
            }

            TextUtils.isEmpty(width) -> {
                activityMainTestBinding.edtWidth.error = "Field ini tidak boleh kosong"
            }

            TextUtils.isEmpty(height) -> {
                activityMainTestBinding.edtHeight.error = "Field ini tidak boleh kosong"
            }

            else -> {
                val valueLength = length.toDouble()
                val valueWidth = width.toDouble()
                val valueHeight = height.toDouble()

                when (v?.id) {
                    R.id.btn_save -> {
                        mainViewModelTest.save(valueLength, valueWidth, valueHeight)
                        visible()
                    }

                    R.id.btn_calculate_circumference -> {
                        activityMainTestBinding.tvResult.text =
                            mainViewModelTest.getCircumference().toString()
                        gone()
                    }

                    R.id.btn_calculate_surface_area -> {
                        activityMainTestBinding.tvResult.text =
                            mainViewModelTest.getSurfaceArea().toString()
                        gone()
                    }

                    R.id.btn_calculate_volume -> {
                        activityMainTestBinding.tvResult.text =
                            mainViewModelTest.getVolume().toString()
                        gone()
                    }
                }
            }
        }
    }

    private fun gone() {
        activityMainTestBinding.btnCalculateVolume.visibility = View.VISIBLE
        activityMainTestBinding.btnCalculateCircumference.visibility = View.VISIBLE
        activityMainTestBinding.btnCalculateSurfaceArea.visibility = View.VISIBLE
        activityMainTestBinding.btnSave.visibility = View.GONE
    }

    private fun visible() {
        activityMainTestBinding.btnCalculateVolume.visibility = View.VISIBLE
        activityMainTestBinding.btnCalculateCircumference.visibility = View.VISIBLE
        activityMainTestBinding.btnCalculateSurfaceArea.visibility = View.VISIBLE
        activityMainTestBinding.btnSave.visibility = View.GONE
    }
}