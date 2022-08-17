package com.example.lab5_ppm
import java.io.Serializable

data class Res(
    val nombre: String,
    val direccion: String,
    val horario: String
) : Serializable