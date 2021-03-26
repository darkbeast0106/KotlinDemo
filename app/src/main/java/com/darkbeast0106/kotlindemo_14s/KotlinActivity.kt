package com.darkbeast0106.kotlindemo_14s

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class KotlinActivity : AppCompatActivity() {
    lateinit var btnKorcsoport : Button
    lateinit var btnVissza : Button
    lateinit var etKor : EditText
    lateinit var textKorcsoport : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        init()
        btnKorcsoport.setOnClickListener{
            val korString = etKor.text.toString().trim()
            if (korString.isEmpty()){
                Toast.makeText(this, "Nincs Megadva kor", Toast.LENGTH_SHORT).show()
                etKor.error = "Nincs Megadva kor"
                return@setOnClickListener
            }
            val kor = korString.toInt()
            lateinit var korCsoport : String
            when (kor){
                in 0..2 -> korCsoport = "csecsemő"
                in 3..12 -> korCsoport = "gyermek"
                in 13..16 -> korCsoport = "serdülő"
                in 17..20 -> korCsoport = "ifjú"
                in 21..60 -> korCsoport = "felnőtt"
                in 61..75 -> korCsoport = "idős"
                in 76..Int.MAX_VALUE -> korCsoport = "agg"
                else -> korCsoport = "érvénytelen"
            }
            val text = """
                $kor
                $korCsoport
            """.trimIndent()
            textKorcsoport.text = text
        }
        btnVissza.setOnClickListener{
            //val intent = Intent(this@KotlinActivity, MainActivity::class.java)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun init() {
        btnKorcsoport = findViewById(R.id.btnKorcsoport)
        btnVissza = findViewById(R.id.btnVissza)
        etKor = findViewById(R.id.etKor)
        textKorcsoport = findViewById(R.id.textKorcsoport)
    }
}