package com.iacc.ivan_vega_semana5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class VendedorAdapter(private val mContext: Context, private val listaVendedores: List<Vendedor>) :
    ArrayAdapter<Vendedor>(mContext, 0, listaVendedores) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItem = convertView
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.layout_vendedores_lista, parent, false)
        }

        val currentVendedor = listaVendedores[position]

        val nombre: TextView = listItem!!.findViewById<View>(R.id.txtNombreLayout) as TextView
        val areaVendedor : TextView = listItem.findViewById<View>(R.id.txtAreaLayout) as TextView
        val numeroVendedor : TextView = listItem.findViewById<View>(R.id.txtNumeroLayout) as TextView

        nombre.text = currentVendedor.nombre
        areaVendedor.text = currentVendedor.area
        numeroVendedor.text = buildString {
            append("N° ")
            append(position + 1)
        }
        return listItem
    }
}