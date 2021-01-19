package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.testapp.databinding.ActivityArrayBinding
import com.example.testapp.utlis.Constants

class ArrayActivity : AppCompatActivity() {

    //С помощью встроенной функции arrayOf() можно передать набор значений, которые будут составлять массив:
    private var numbers: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    //Также инициализировать массив значениями можно следующим способом:
    val numbersAnother = Array(3, { 5 }) // [5, 5, 5]

    // Текстовый массив
    val stringArray = Array(10){""}


    private lateinit var binding: ActivityArrayBinding
    private val text = "<Привет>, это простой <текст>, <созданный> исключительно в тестовых целях"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArrayBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //С помощью индексов мы можем обратиться к определенному элементу в массиве.
        numbers[0] = 7

        //TODO Выпарсить из строки слова в скобках

        // Находим общее количество вхождений первого элемента, чтобы понять размер массива
        var counter = 0
        for (n in text.indices){
            if (text[n] == '<'){
                counter++
            }
        }

//        Log.d(Constants.TAG, "onCreate: $counter")

        // Создаем массивы
        var startIndex = IntArray(counter)
        var endIndex  = IntArray(counter)
        var startCounter = 0
        var endCounter = 0

        // Проходимся по массиву текста и добавляем в массивы номера элементов со скобкой
        for (n in text.indices){
            if (text[n] == '<'){
                startIndex[startCounter] = n
                startCounter++
            } else if (text[n] == '>') {
                endIndex[endCounter] = n
                endCounter++
            }
        }
//        Log.d(Constants.TAG, "onCreate: st ${startIndex[0]}, end ${endIndex[0]}")

        // Создаем массив строк и выпарсиваем туда слова в скобках по двум индексам
        val wordArray = Array(counter){""}
        for (n in 0 until counter){
            wordArray[n] = text.substring(startIndex[n] + 1, endIndex[n])
        }

        // Вывести все в лог
        for (n in wordArray.indices){
            Log.d(Constants.TAG, "onCreate: ${wordArray[n]}")
        }
    }
}