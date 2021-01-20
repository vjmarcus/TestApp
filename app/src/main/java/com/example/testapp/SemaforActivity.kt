package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.testapp.databinding.ActivitySemaforBinding
import com.example.testapp.databinding.StringMainBinding
import com.example.testapp.utlis.Constants
import java.util.*
import kotlin.collections.ArrayList

class SemaforActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySemaforBinding
    private var timer: Timer? = null
    private var isRun : Boolean = false
    private var counter = 0
    private val imageList: ArrayList<Int> = arrayListOf(R.drawable.semafor_red,
        R.drawable.semafor_yellow, R.drawable.semafor_green)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySemaforBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.imageViewSemafor.setImageResource(R.drawable.semafor_grey)
        binding.imageButtonStartStop.setOnClickListener { view:View ->
            Log.d(Constants.TAG, "onCreate: click!")
            startStopTimer()
        }
    }

    private fun startStopTimer() {
        if (isRun) {
            timer?.cancel()
            binding.imageViewSemafor.setImageResource(R.drawable.semafor_grey)
            isRun = false
        } else {
            timer = Timer()
            counter = 0
            timer?.schedule(object : TimerTask() {
                override fun run() {
                    changeImage()
                }
            }, 0, 1000)
            isRun = true
        }
    }

    private fun changeImage() {
        binding.imageViewSemafor.setImageResource(imageList[counter])
        counter++
        if (counter == 3) counter = 0
    }


}