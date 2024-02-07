package com.iacc.ivan_vega_semana5

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.ListView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class ListaActivity : AppCompatActivity() {

    private lateinit var adapter: VendedorAdapter
    private lateinit var listView : ListView
    private lateinit var selectedView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        val btn = findViewById<android.widget.Button>(R.id.btnVolverLista)
        btn.setOnClickListener {
            finish()
        }

        val VendedorList = listOf(
            Vendedor("Ivan Vega", "Ventas", 11),
            Vendedor("Juan Perez", "Ventas", 12),
            Vendedor("Maria Lopez", "Ventas", 13),
            Vendedor("Pedro Martinez", "Ventas", 14),
            Vendedor("Luisa Rodriguez", "Ventas", 15),
            Vendedor("Carlos Sanchez", "Ventas", 16),
            Vendedor("Ana Garcia", "Ventas", 17),
            Vendedor("Jose Hernandez", "Ventas", 18),
            Vendedor("Sofia Diaz", "Ventas", 19),
            Vendedor("Ricardo Torres", "Ventas", 20),
        )

         adapter = VendedorAdapter(this, VendedorList)
         listView = findViewById(R.id.listaVendedores)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->

            if ((position + 1) == 3) {
                MediaPlayer.create(this, R.raw.cuak_sound_effect).start()
            } else {
                selectedView = view.findViewById<ImageView>(R.id.imgFotoLayout)
                startForResult.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
            }
        }

    }

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data
                val bitmap = intent?.extras?.get("data") as Bitmap
                selectedView.setImageBitmap(bitmap)
            }
        }

}