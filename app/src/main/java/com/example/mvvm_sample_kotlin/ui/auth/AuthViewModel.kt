package com.example.mvvm_sample_kotlin.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import data.repositories.UserRepository

class AuthViewModel : ViewModel() {

    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null

    fun onLoginButtonClick(view: View) {
        authListener?.Started()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.Failure("Invalid email or password!")
            return
        }
        val loginResponse = UserRepository().userLogin(email!!, password!!)
        authListener?.Success(loginResponse)

    }


}