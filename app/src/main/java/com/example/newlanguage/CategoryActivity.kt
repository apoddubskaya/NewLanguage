package com.example.newlanguage

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_category.*

class CategoryActivity : AppCompatActivity() {
    val TAG = "Category"
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        val categoryType = intent.getStringExtra("categoryType")
        val colorID = when (categoryType) {
            resources.getString(R.string.category1) -> R.color.category1Background
            resources.getString(R.string.category2) -> R.color.category2Background
            resources.getString(R.string.category3) -> R.color.category3Background
            else -> R.color.category4Background
        }
        recyclerView.setBackgroundColor(ContextCompat.getColor(applicationContext, colorID!!))
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        val numbersList = listOf(
            Card("One", "Один", R.drawable.number_one),
            Card("Two", "Два", R.drawable.number_two),
            Card("Three", "Три", R.drawable.number_three),
            Card("Four", "Четыре", R.drawable.number_four),
            Card("Five", "Пять", R.drawable.number_five),
            Card("Six", "Шесть", R.drawable.number_six),
            Card("Seven", "Семь", R.drawable.number_seven),
            Card("Eight", "Восемь", R.drawable.number_eight),
            Card("Nine", "Девять", R.drawable.number_nine),
            Card("Ten", "Десять", R.drawable.number_ten)
        )
        val colorsList = listOf(
            Card("Black", "Чёрный", R.drawable.color_black),
            Card("White", "Белый", R.drawable.color_white),
            Card("Gray", "Серый", R.drawable.color_gray),
            Card("Brown", "Коричневый", R.drawable.color_brown),
            Card("Green", "Зеленый", R.drawable.color_green),
            Card("Yellow", "Желтый", R.drawable.color_mustard_yellow),
            Card("Red", "Красный", R.drawable.color_red)
        )
        val familyList = listOf(
            Card("Mother", "Мама", R.drawable.family_mother),
            Card("Father", "Папа", R.drawable.family_father),
            Card("Grandmother", "Бабушка", R.drawable.family_grandmother),
            Card("Grandfather", "Дедушка", R.drawable.family_grandfather),
            Card("Older sister", "Старшая сестра", R.drawable.family_older_sister),
            Card("Younger sister", "Младшая сестра", R.drawable.family_younger_sister),
            Card("Older brother", "Старший брат", R.drawable.family_older_brother),
            Card("Younger brother", "Младший брат", R.drawable.family_younger_brother),
            Card("Daughter", "Дочь", R.drawable.family_daughter),
            Card("Son", "Сын", R.drawable.family_son)
        )
        val phraseList = listOf(
            Card("Good morning!", "Доброе утро!", null),
            Card("Good evening!", "Добрый вечер!", null),
            Card("Good night!", "Спокойной ночи!", null)
        )
        val categoryList = when (categoryType) {
            resources.getString(R.string.category1) -> numbersList
            resources.getString(R.string.category2) -> colorsList
            resources.getString(R.string.category3) -> familyList
            else -> phraseList
        }
        recyclerView.adapter = CardAdapter(categoryList)
    }

}
