package com.example.lab5_ppm

import android.app.Activity
import android.widget.Button
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton


class MainActivity : AppCompatActivity() {
    private lateinit var btn : MaterialButton
    private lateinit var btn_descargar : MaterialButton
    private lateinit var btn_detalles : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.iniciar)
        btn.setOnClickListener() {
            Toast.makeText(applicationContext, "Diego Alejandro Morales Escobar", Toast.LENGTH_SHORT).show()
        }
        btn_descargar= findViewById(R.id.descargar)
        btn_descargar.setOnClickListener(){
            var url = Intent(android.content.Intent.ACTION_VIEW)
            url.data = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.youtube&hl=es_GT&gl=US")
            startActivity(url)
        }
        val directions= findViewById(R.id.directions) as ImageView
        directions.setOnClickListener(){
            var url = Intent(android.content.Intent.ACTION_VIEW)
            url.data = Uri.parse("https://www.google.com/maps/place/Sushi+Itto+•+Paseo+Cayalá/@14.6101579,-90.4868488,15z/data=!4m5!3m4!1s0x0:0x94048be95f6f45cc!8m2!3d14.6102124!4d-90.4868512")
            startActivity(url)
        }
        btn_detalles= findViewById(R.id.detalles)
        btn_detalles.setOnClickListener(){
            val nombrerestaurante= getString(R.string.text_restaurante)
            val direccionrestaurante= getString(R.string.text_direccion)
            val horariorestaurante= getString(R.string.text_horario)
            val res= Res(nombrerestaurante,direccionrestaurante,horariorestaurante)
            val intent = Intent(this, details::class.java)
            intent.putExtra("EXTRA", res)
            startActivity(intent)
        }


    }


}