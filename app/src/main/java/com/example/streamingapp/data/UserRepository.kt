package com.example.streamingapp.data

class UserRepository(private val database: UserDatabase) {
    suspend fun insertUser(user: UserEntity) {
        database.userDao().insertUser(user)
    }

    suspend fun getUserByUsernameAndPassword(username: String, password: String): UserEntity? {
        return database.userDao().getUserByUsernameAndPassword(username, password)
    }
}
