package com.iacc.ivan_vega_semana5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<android.widget.Button>(R.id.btnListaGo)
        btn.setOnClickListener{
            abrirListaVendedores()
        }

    }


    fun abrirListaVendedores(){
        val intent = Intent(this, ListaActivity::class.java)
        startActivity(intent)
    }
}