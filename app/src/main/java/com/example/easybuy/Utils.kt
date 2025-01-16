package com.example.easybuy

import android.widget.EditText

fun EditText.isEmpty(): Boolean{
    if(this.text.toString().isEmpty()){
        this.error = "this field needs to be filled up"
        return true
    }
    else
        return false
}