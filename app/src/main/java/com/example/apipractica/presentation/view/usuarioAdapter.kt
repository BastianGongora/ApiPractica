package com.example.apipractica.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apipractica.R
import com.example.apipractica.data.model.Usuario
import com.example.apipractica.databinding.ItemUsuarioBinding

class usuarioAdapter(private val usuarios: List<Usuario>) :
    RecyclerView.Adapter<usuarioAdapter.UsuarioViewHolder>() {

    class UsuarioViewHolder(private val binding: ItemUsuarioBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(usuario: Usuario) {
            binding.tvTitle.text = usuario.title
            binding.tvBody.text = usuario.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val binding = ItemUsuarioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UsuarioViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        holder.bind(usuarios[position])
    }

    override fun getItemCount(): Int = usuarios.size
}