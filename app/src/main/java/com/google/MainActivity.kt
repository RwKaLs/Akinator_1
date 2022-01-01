package com.google

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var user_btn : Button
    lateinit var comp_btn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        user_btn = findViewById(R.id.btn_user)
        comp_btn = findViewById(R.id.btn_comp)
        val ic : Intent = Intent(this, Comp_Game::class.java)
        val iu : Intent = Intent(this, User_Game::class.java)
        val onclck: View.OnClickListener = View.OnClickListener { v ->
            when (v.id){
                R.id.btn_user -> startActivity(iu)
                R.id.btn_comp -> startActivity(ic)
            }
        }
        user_btn.setOnClickListener(onclck)
        comp_btn.setOnClickListener(onclck)
    }
}