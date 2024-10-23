package com.example.streamingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.streamingapp.data.UserEntity
import com.example.streamingapp.data.UserViewModel

class AccountDetailsActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AccountDetailsScreen(username = "your_username") // Cambia esto según tu lógica
        }
    }

    @Composable
    fun AccountDetailsScreen(username: String) {
        var user by remember { mutableStateOf<UserEntity?>(null) }
        val password = "your_password" // Obtén la contraseña de manera segura según tu lógica

        LaunchedEffect(username) {
            userViewModel.getUserByUsernameAndPassword(username, password) { result ->
                user = result
            }
        }

        // Mostrar la información del usuario
        Column(modifier = Modifier.padding(16.dp)) {
            if (user != null) {
                Text("Nombre de usuario: ${user!!.username}")
                Text("Nombre: ${user!!.name}")
                Text("Apellido: ${user!!.lastName}")
                Text("Email: ${user!!.email}")
                Text("Ubicación: ${user!!.location}")
            } else {
                Text("Cargando información del usuario...")
            }
        }
    }
}












