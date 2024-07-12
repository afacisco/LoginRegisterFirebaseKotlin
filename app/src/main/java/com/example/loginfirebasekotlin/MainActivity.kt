package com.example.loginfirebasekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*
Autor: Juan Francisco Sánchez González
Fecha: 06/07/2024
Clase: Actividad vacía que se verá al entrar a la aplicación. Se trata de una app de login y signup,
conectada al servicio de autenticación de Firebase.
*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}