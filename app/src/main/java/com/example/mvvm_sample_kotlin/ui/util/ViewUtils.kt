package com.example.mvvm_sample_kotlin.ui.util

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

fun Context.toast(message:String){
    Toast.makeText(this,message,Toast.LENGTH_LONG).show()
}

//to make prograssbar visible
fun ProgressBar.show(){
    visibility = View.VISIBLE

}

fun ProgressBar.hide(){
    visibility = View.GONE

}