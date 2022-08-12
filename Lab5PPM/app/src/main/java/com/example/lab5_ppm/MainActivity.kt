package com.example.lab5_ppm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    private lateinit var btn : MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.iniciar)
        btn.setOnClickListener() {
            Toast.makeText(applicationContext, "Diego Alejandro Morales Escobar", Toast.LENGTH_SHORT).show()
        }
    }


}