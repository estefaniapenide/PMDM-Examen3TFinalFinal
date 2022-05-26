package com.example.penide_estefania_examen3t

import android.app.AlertDialog
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.penide_estefania_examen3t.databinding.ElementoBinding
import com.google.android.material.snackbar.Snackbar

class CustomAdapter (private val listaDiscos:MutableList<Album>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
    class ViewHolder(binding: ElementoBinding): RecyclerView.ViewHolder(binding.root){
        val elemento = binding.root
        val titulo =binding.tvTitulo
        val autor = binding.tvAutor
        val caratula =binding.imageViewCaratula
        val info = binding.imageViewInfo
        val del = binding.imageViewFDel


        init{
            elemento.setOnClickListener {
                Toast.makeText(binding.root.context,"Click en ${titulo.text}", Toast.LENGTH_SHORT).show()
            }

            /*info.setOnClickListener {
                AlertDialog.Builder(it.context).setMessage("${listaDiscos[position].descripcion.text}").setTitle("${titulo.text}").create()
                    .show()
            }*/


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ElementoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titulo.text = listaDiscos[position].titulo
        holder.autor.text = listaDiscos[position].autor
        holder.caratula.setImageResource(listaDiscos[position].caratula)

        if (position % 2 == 0) {
            holder.elemento.setBackgroundColor(Color.CYAN)
        } else {
            holder.elemento.setBackgroundColor(Color.LTGRAY)
        }

        holder.del.setOnClickListener {
            Snackbar.make(it, "${holder.autor.text} - ${holder.titulo.text}", Snackbar.LENGTH_LONG).setAction("ELIMINAR",
                View.OnClickListener {
                    listaDiscos.removeAt(position)
                    // notificamos la eliminación del elemento
                    notifyItemRemoved(position)
                    notifyItemRangeChanged(position, listaDiscos.size)
                }).show()//añadir el boton de eliminar aqui

        }

        holder.info.setOnClickListener {
            AlertDialog.Builder(it.context).setMessage("${listaDiscos[position].descripcion}").setTitle("${holder.autor.text} - ${holder.titulo.text}").create().show()
        }

    }

    override fun getItemCount(): Int {
        return listaDiscos.size
    }

}