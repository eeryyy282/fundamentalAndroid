package com.example.fundamentalandroid.learnlivedata

import android.os.SystemClock
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Timer
import java.util.TimerTask

class MainViewModelLiveData : ViewModel() {

    private val mInitialTime = SystemClock.elapsedRealtime()
    private val mElapsedTime = MutableLiveData<Long?>()

    init {
        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                val newValue = (SystemClock.elapsedRealtime() - mInitialTime) / 1000
                mElapsedTime.postValue(newValue)
            }

        }, ONE_SECOND.toLong(), ONE_SECOND.toLong())
    }

    fun getElapsedTime(): LiveData<Long?> {
        return mElapsedTime
    }

    companion object {
        private const val ONE_SECOND = 1000
    }
}