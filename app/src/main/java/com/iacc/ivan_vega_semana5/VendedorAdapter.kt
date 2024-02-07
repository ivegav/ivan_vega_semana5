package com.iacc.ivan_vega_semana5

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.media.MediaPlayer
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class VendedorAdapter(private val mContext: Context, private val listaVendedores: List<Vendedor>) :
    ArrayAdapter<Vendedor>(mContext, 0, listaVendedores) {



    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItem = convertView
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.layout_vendedores_lista, parent, false)
        }


        val currentVendedor = listaVendedores[position]

        val nombre: TextView = listItem!!.findViewById(R.id.txtNombreLayout)
        val areaVendedor : TextView = listItem.findViewById(R.id.txtAreaLayout)
        val numeroVendedor : TextView = listItem.findViewById(R.id.txtNumeroLayout)

        nombre.text = currentVendedor.nombre
        areaVendedor.text = currentVendedor.area
        numeroVendedor.text = buildString {
            append("N° ")
            append(position + 1)
        }

        return listItem
    }


}