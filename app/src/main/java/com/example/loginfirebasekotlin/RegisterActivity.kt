package com.example.loginfirebasekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

/*
Autor: Juan Francisco Sánchez González
Fecha: 06/07/2024
Clase: Actividad de Registro (Email, Password y RepetirPassword) conectada al servicio de autenticación de Firebase.
*/

class RegisterActivity : AppCompatActivity() {

    // lateinit -> que se van a inicializar después
    private lateinit var registerEmail: EditText
    private lateinit var registerPassword: EditText
    private lateinit var registerRepeatPassword: EditText
    private lateinit var registerButton: Button
    private lateinit var registerGoLoginButton: Button

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = Firebase.auth

        registerEmail = findViewById(R.id.register_email)
        registerPassword = findViewById(R.id.register_password)
        registerRepeatPassword = findViewById(R.id.register_repeat_password)
        registerButton = findViewById(R.id.register_button)
        registerGoLoginButton = findViewById(R.id.register_gologin_button)

        registerButton.setOnClickListener(){
            val email = registerEmail.text.toString()
            val password = registerPassword.text.toString()
            val repeatPassword = registerRepeatPassword.text.toString()

            if (password.equals(repeatPassword) && checkEmpty(email, password, repeatPassword)) {
                register(email, password)
            }
        }

        registerGoLoginButton.setOnClickListener() {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun register(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(applicationContext, "Error en el registro!!", Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun checkEmpty(email: String, password: String, repeatPassword: String): Boolean {
        return email.isNotEmpty() && password.isNotEmpty() && repeatPassword.isNotEmpty()
    }
}