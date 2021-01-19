package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testapp.databinding.StringMainBinding

class StringActivity : AppCompatActivity() {

    private lateinit var binding: StringMainBinding
    var text: String = "<Привет>, это простой тестовый <текст> без сложных форм как у вас дела надеюсь" +
            "<все> <хорошо>"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = StringMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val text1 = text.substringAfter('<')
        val text2 = text1.substringBefore('>')
        binding.textView.text = text2
        val text3 = text.substringAfter('>')
        val text4 = text3.substringAfter('<')
        val text5 = text4.substringBefore('>')
        binding.textView2.text = text5
    }
}