package com.example.apipractica.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apipractica.R
import com.example.apipractica.data.network.UsuarioApiClient
import com.example.apipractica.databinding.ActivityMainBinding
import com.example.apipractica.domain.RetrofitHelper
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var usuarioAdapter: usuarioAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Realiza la llamada a la API
        val retrofit = RetrofitHelper.getRetrofit()
        val apiClient = retrofit.create(UsuarioApiClient::class.java)

        lifecycleScope.launch {
            try {
                val usuarios = apiClient.getPosts()
                usuarioAdapter = usuarioAdapter(usuarios)
                binding.recyclerView.adapter = usuarioAdapter
            } catch (e: Exception) {
                Log.e("MainActivity", "Error: ${e.message}")
            }

        }
    }
}