package com.example.streamingapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val lastName: String,
    val username: String,
    val email: String,
    val password: String,
    val location: String
)
