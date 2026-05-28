package com.example.notepad.data

sealed class NetworkResponse<out T> {

    data class Success<T>(val data: T) : NetworkResponse<T>()

    object Loading : NetworkResponse<Nothing>()

    data class Error(val message: String) : NetworkResponse<Nothing>()
}