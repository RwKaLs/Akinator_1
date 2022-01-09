package com.google

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Exception
import kotlin.properties.Delegates
import kotlin.random.Random

class Comp_Game : AppCompatActivity() {
    private lateinit var tv_hint : TextView
    private lateinit var ed_ans : EditText
    private lateinit var try_btn: Button
    private var num by Delegates.notNull<Int>()
    private val from : Int = 1
    private val till : Int = 1000
    private var attempts by Delegates.notNull<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comp_game)
        tv_hint = findViewById(R.id.tv_hint)
        ed_ans = findViewById(R.id.edit_ans)
        try_btn = findViewById(R.id.try_btn)
        attempts = 10
        num = Random.nextInt(from, till)
        val onclck: View.OnClickListener = View.OnClickListener{ v ->
            if (v.id == R.id.try_btn) {
                try {
                    when {
                        ed_ans.text.toString().toInt() == num -> {
                            tv_hint.text = "Получилось! Красава"
                        }
                        ed_ans.text.toString().toInt() > num -> {
                            tv_hint.text = "Надо меньше"
                            attempts -= 1
                            howAt()
                        }
                        ed_ans.text.toString().toInt() < num -> {
                            tv_hint.text = "Надо больше"
                            attempts -= 1
                            howAt()
                        }
                    }
                } catch (e : Exception){
                    tv_hint.text = "Неправильный ввод"
                }
            }
        }
        try_btn.setOnClickListener(onclck)
    }
    @SuppressLint("SetTextI18n")
    fun howAt() {
        if (attempts < 1) {
            tv_hint.text = "Загадываю новое! Пробуй!"
            num = Random.nextInt(from, till)
            attempts = 10
        }
    }
}