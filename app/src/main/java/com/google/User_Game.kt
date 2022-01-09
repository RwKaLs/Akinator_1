package com.google

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.properties.Delegates

class User_Game : AppCompatActivity() {
    private lateinit var tv_us : TextView
    private lateinit var btn_l : Button
    private lateinit var btn_r : Button
    private lateinit var btn_y : Button
    private var ceff by Delegates.notNull<Int>()
    private var attempts : Int = 10
    private var fl : Int = 0
    private var d : Int = 1
    private var u : Int = 1000

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_game)
        tv_us = findViewById(R.id.tv_us)
        btn_l = findViewById(R.id.btn_lower)
        btn_r = findViewById(R.id.btn_bigger)
        btn_y = findViewById(R.id.btn_yeah)
        ceff = 500
        tv_us.text = "Это 500?"
        val onclck : View.OnClickListener = View.OnClickListener { v ->
            when (v.id) {
                R.id.btn_yeah -> {
                    if (fl == 1){
                        ceff = 500
                        tv_us.text = "Это 500?"
                        fl = 0
                        attempts = 10
                        d = 1
                        u = 1000
                    } else {
                        tv_us.text = "Я молодец! Ещё раз?"
                        fl = 1
                    }
                }
                R.id.btn_lower -> {
                    u -= ceff
                    ceff = (u-d)/2
                    tv_us.text = "Это ${d + ceff}?"
                    attempts--
                }
                R.id.btn_bigger -> {
                    d += ceff
                    ceff = (u-d)/2
                    tv_us.text = "Это ${d + ceff}?"
                    attempts--
                }
            }
            howAt()
        }
        btn_l.setOnClickListener(onclck)
        btn_r.setOnClickListener(onclck)
        btn_y.setOnClickListener(onclck)
    }
    private fun howAt(){
        if (attempts < 1){
            tv_us.text = "Кто-то врёт! Заново?"
            attempts = 10
        }
    }
}