package com.example.easybuy.views.register

data class UserRegister(
    val name:String,
    val email: String,
    val password: String,
    val userType: String,
    var userId: String
)
