package com.example.easybuy.data.repository

import com.example.easybuy.core.Nodes
import com.example.easybuy.data.model.AuthSource
import com.example.easybuy.views.login.UserLogin
import com.example.easybuy.views.register.UserRegister
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val jAuth: FirebaseAuth,
    private val db:FirebaseFirestore
) :AuthSource {
    override fun userRegistration(user: UserRegister):Task<AuthResult> {

        return jAuth.createUserWithEmailAndPassword(user.email, user.password)

    }

    override fun userLogin(user:UserLogin):Task<AuthResult> {


        return jAuth.signInWithEmailAndPassword(user.email, user.password)
    }

    override fun forgetPassword() {

    }

    override fun createUser(user:UserRegister):Task<Void> {

    return db.collection(Nodes.USER).document(user.userId).set(user)


    }
}