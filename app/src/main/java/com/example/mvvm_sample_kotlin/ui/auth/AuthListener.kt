package com.example.mvvm_sample_kotlin.ui.auth

import androidx.lifecycle.LiveData

interface AuthListener {
    fun Started()
    fun Success(loginResponse: LiveData<String>)
    fun Failure(message:String)
}