package com.example.recomendarfilme

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
       if(savedInstanceState == null) {
           supportFragmentManager.beginTransaction()
                .replace(R.id.containerToolbar, ToolbarFragment())
                .commit()
       }
    }




    fun recomend(view: View) {
        val idadeEditText = findViewById<EditText>(R.id.txtNumber2)
        val idade = idadeEditText.text.toString().toIntOrNull()

        val recomendar = findViewById<TextView>(R.id.txtRecomendar)

        if (idade != null){
            return when (idade){
                in 0..12 -> recomendar.text = "Recomendamos filmes infantis"
                in 13..18 -> recomendar.text = "Recomendamos filmes adolescentes"
                else -> recomendar.text = "Recomendamos filmes para adultos"
            }

        } else{
            recomendar.text = "Erro nenhuma idade indicada"
        }


}}