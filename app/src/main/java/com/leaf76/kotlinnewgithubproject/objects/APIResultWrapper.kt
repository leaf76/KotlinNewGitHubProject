package com.leaf76.kotlinnewgithubproject.objects

sealed class APIResultWrapper<out R> {
    data class Success<out T>(val data: T) : APIResultWrapper<T>()
    data class Error(val exception: Exception) : APIResultWrapper<Nothing>()
}