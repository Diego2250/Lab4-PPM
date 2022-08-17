package com.example.lab5_ppm

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import android.content.Intent
import android.widget.TextView
import android.net.Uri
import androidx.activity.result.contract.ActivityResultContracts
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat

class details : AppCompatActivity() {
    private lateinit var restaurante: TextView
    private lateinit var direccion: TextView
    private lateinit var horario: TextView
    private lateinit var llamar: MaterialButton
    private lateinit var iniciar_visita: MaterialButton
    private lateinit var constraint: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        restaurante = findViewById(R.id.restaurante)
        direccion = findViewById(R.id.direccion)
        horario = findViewById(R.id.horario)
        llamar = findViewById(R.id.btn_llamar)
        iniciar_visita = findViewById(R.id.btn_iniciar_visita)
        constraint = findViewById(R.id.constraintLayout2)

        val res: Res = intent.getSerializableExtra("EXTRA") as Res
        restaurante.text = "${res.nombre}"
        direccion.text = "${res.direccion}"
        horario.text = "${res.horario}"

        llamar.setOnClickListener {
            val phoneNum = "2493 7979"
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNum"))
            startActivity(intent)
        }
            val requestCamera =registerForActivityResult(ActivityResultContracts.RequestPermission()) {
                if (it) {
                    Toast.makeText(applicationContext, "Solicitud aceptada", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Snackbar.make(constraint, "Se necesitan los permisos de la cámara", Snackbar.LENGTH_INDEFINITE).setAction("OK"){
                        closeContextMenu()
                    }.show()
                }
            }
        iniciar_visita.setOnClickListener {
            requestCamera.launch(android.Manifest.permission.CAMERA)
        }

    }
}