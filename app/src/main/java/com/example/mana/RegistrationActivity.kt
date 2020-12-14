package com.example.mana

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.registration.*

class RegistrationActivity : AppCompatActivity (){
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        signup_button.setOnClickListener {
            signUpUser()
        }
    }

    private fun signUpUser (){
        if (email_registration.text.toString().isEmpty()){
            email_registration.error = "Please enter email"
            email_registration.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email_registration.text.toString()).matches()){
            email_registration.error = "Please enter a valid email"
            email_registration.requestFocus()
            return
        }

        if(password_registration.text.toString().isEmpty()){
            password_registration.error = "Please enter a password"
            password_registration.requestFocus()
            return
        }

        auth.createUserWithEmailAndPassword(email_registration.text.toString(), password_registration.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("Registration", "createUserWithEmail:success")
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Registration", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }

                // ...
            }
    }




}