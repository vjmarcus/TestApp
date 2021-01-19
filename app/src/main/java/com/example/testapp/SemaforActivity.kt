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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySemaforBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val imageList: ArrayList<Int> = arrayListOf(R.drawable.semafor_green,
            R.drawable.semafor_yellow, R.drawable.semafor_red)

        binding.imageViewSemafor.setImageResource(R.drawable.semafor_green)
        binding.imageButtonStartStop.setOnClickListener { view:View ->
            Log.d(Constants.TAG, "onCreate: click!")
        }
    }

    private fun startStopTimer() {

    }


}