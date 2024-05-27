package com.example.apipractica.data.network

import com.example.apipractica.data.model.Usuario
import retrofit2.http.GET

interface UsuarioApiClient {

    @GET("posts")
    suspend fun getPosts(): List<Usuario>
}