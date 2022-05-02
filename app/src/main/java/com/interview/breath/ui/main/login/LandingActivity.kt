package com.interview.breath.ui.main.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.interview.breath.R
import com.interview.breath.ui.main.LoginActivity

class LandingActivity : AppCompatActivity() {
    private var mGoogleSignInClient: GoogleSignInClient? = null
    private lateinit var signOutBtn: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)
        signOutBtn = findViewById(R.id.sign_out_button)

        signOutBtn.setOnClickListener {
            signOut()
        }

        val gso =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        val acct = GoogleSignIn.getLastSignedInAccount(this)

        if (acct != null) {
            val personName = acct.displayName
            //person_name.setText(personName)
            val personEmail = acct.email
            // person_email.setText(personEmail)
            val personId = acct.id
            // person_id.setText(personId)
        }
    }


    fun signOut() {
        mGoogleSignInClient?.signOut()?.addOnCompleteListener(this, object : OnCompleteListener<Void> {
            override fun onComplete(p0: Task<Void>) {
                Toast.makeText(this@LandingActivity, "Signed Out", Toast.LENGTH_LONG).show()
            }
        })

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}