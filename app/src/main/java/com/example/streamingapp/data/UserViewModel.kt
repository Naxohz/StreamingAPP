package com.example.streamingapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserRepository

    init {
        val database = UserDatabase.getDatabase(application.applicationContext)
        repository = UserRepository(database)
    }

    fun insertUser(user: UserEntity) {
        viewModelScope.launch {
            repository.insertUser(user)
        }
    }

    // Cambiar este método para que no sea suspendido y para actualizar el estado de la UI
    fun getUserByUsernameAndPassword(username: String, password: String, onResult: (UserEntity?) -> Unit) {
        viewModelScope.launch {
            val user = repository.getUserByUsernameAndPassword(username, password)
            onResult(user)
        }
    }
}

