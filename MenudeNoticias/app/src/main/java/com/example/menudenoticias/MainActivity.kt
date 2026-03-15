package com.example.menudenoticias

import androidx.fragment.app.Fragment
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val bottomnavigation = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomnavigation.setOnItemSelectedListener {
            var fragment: Fragment?= null

            when(it.itemId){
                R.id.nav_esportes -> fragment = EsportesFragment()
                R.id.nav_tech -> fragment = TechFragment()
                R.id.nav_entreterimento -> fragment = EntretenimentoFragment()
                R.id.nav_politica -> fragment = PoliticaFragment()

            }

            if(fragment != null){
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, fragment)
                    .commit()
            }
            true


        }

        if (savedInstanceState == null) {
            bottomnavigation.selectedItemId = R.id.nav_esportes
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}