package com.example.testapp

import android.net.sip.SipSession
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.testapp.R
import com.example.testapp.databinding.ActivityListViewBinding
import com.example.testapp.databinding.ActivitySemaforBinding
import com.example.testapp.utlis.Constants
import java.util.ArrayList

class ListViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val list = getFakeList()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        binding.listView.adapter = adapter
        binding.listView.setOnItemClickListener{parent, view, position, id ->
            Log.d(Constants.TAG, "onCreate: $position")
        }
    }

    private fun getFakeList(): List<String> {
        val list = ArrayList<String>()
        for (n in 0..40) {
            list.add("Hello$n")
        }
        return list
    }
}