package com.example.mvvm_sample_kotlin.ui.auth

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm_sample_kotlin.R
import com.example.mvvm_sample_kotlin.databinding.ActivityLoginBinding
import com.example.mvvm_sample_kotlin.ui.util.hide
import com.example.mvvm_sample_kotlin.ui.util.show
import com.example.mvvm_sample_kotlin.ui.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding
        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)

        //to get the viewmodel
        val viewModel =ViewModelProviders.of(this).get(AuthViewModel::class.java)
        //to bind our data with the ui
        binding.viewmodel = viewModel

        //define the authlistener to the viewmodel
        viewModel.authListener = this


    }

    override fun Started() {
        progress_bar.show()

    }

    override fun Success(loginResponse: LiveData<String>) {
        loginResponse.observe(this, Observer {
            progress_bar.hide()
            toast(it)
        })
    }

    override fun Failure(message: String) {
        progress_bar.hide()
        toast(message )
    }
}


