package com.darkbeast0106.kotlindemo_14s

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Java2KotlinActivity : AppCompatActivity() {
    var btnKorcsoport: Button? = null
    var btnVissza: Button? = null
    var etKor: EditText? = null
    var textKorcsoport: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java2_kotlin)
        init()
        btnKorcsoport!!.setOnClickListener { v: View? ->
            val korString = etKor!!.text.toString().trim { it <= ' ' }
            if (korString.isEmpty()) {
                etKor!!.error = "Nincs Megadva kor"
                return@setOnClickListener
            }
            val kor = korString.toInt()
            /*
            0-2: csecsemő
            3-12: gyermek
            13-16: serdülő
            17-20: ifjú
            21-60: felnőtt
            61-75: idős
            76-: agg
             */
            var korcsoport = ""
            korcsoport = if (kor < 0) {
                "érvénytelen"
            } else if (kor < 3) {
                "csecsemő"
            } else if (kor < 13) {
                "gyermek"
            } else if (kor < 17) {
                "serdülő"
            } else if (kor < 21) {
                "ifjú"
            } else if (kor < 61) {
                "felnőtt"
            } else if (kor < 76) {
                "idős"
            } else {
                "agg"
            }
            val text = kor
                    .toString() + "\n" + korcsoport
            textKorcsoport!!.text = text
        }
        btnVissza!!.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
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