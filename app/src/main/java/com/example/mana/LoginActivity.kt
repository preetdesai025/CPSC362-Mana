package com.example.mana

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.login.*

class LoginActivity : AppCompatActivity () {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        auth = FirebaseAuth.getInstance()

        login_button.setOnClickListener {
           doLogin()
        }

    }

    private fun doLogin() {

        if (email_login.text.toString().isEmpty()){
            email_login.error = "Please enter email"
            email_login.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email_login.text.toString()).matches()){
            email_login.error = "Please enter a valid email"
            email_login.requestFocus()
            return
        }

        if(password_login.text.toString().isEmpty()){
            email_login.error = "Please enter a password"
            email_login.requestFocus()
            return
        }

        auth.signInWithEmailAndPassword(email_login.text.toString(), password_login.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("Login", "signInWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Login", "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)
                    // ...
                }

                // ...
            }


    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI (currentUser: FirebaseUser?) {
        if (currentUser != null){
            val intent = Intent(this, CustomerDashActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(baseContext, "Login failed", Toast.LENGTH_SHORT).show()
        }
    }


}

