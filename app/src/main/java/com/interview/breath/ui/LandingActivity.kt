package com.interview.breath.ui

import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.interview.breath.R
import com.interview.breath.databinding.ActivityLandingBinding


class LandingActivity : AppCompatActivity() {
    private var mGoogleSignInClient: GoogleSignInClient? = null
    private lateinit var signOutBtn: AppCompatButton
    private lateinit var binding: ActivityLandingBinding
    private var recyclerView: RecyclerView? = null
    private var gridLayoutManager: GridLayoutManager? = null
    private var adapter: RecyclerAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)
        Log.d("***********", "onCreate")
        binding = ActivityLandingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        recyclerView = findViewById<View>(R.id.rv_design) as RecyclerView
        gridLayoutManager = GridLayoutManager(this, getNumberOfRows())
        recyclerView!!.layoutManager = gridLayoutManager
        adapter = RecyclerAdapter(this@LandingActivity)
        recyclerView!!.adapter = adapter

        val gso =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.action_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.acction_Logout -> {
                signOut()
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun signOut() {
        mGoogleSignInClient?.signOut()?.addOnCompleteListener(this, object : OnCompleteListener<Void> {
            override fun onComplete(p0: Task<Void>) {
                Toast.makeText(this@LandingActivity, "Signed Out Successful", Toast.LENGTH_LONG).show()
            }
        })

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }


    private fun getNumberOfRows(): Int {
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        val width = dm.widthPixels
        val height = dm.heightPixels
        val wi = width.toDouble() / dm.xdpi.toDouble()
        val hi = height.toDouble() / dm.ydpi.toDouble()
        val x = Math.pow(wi, 2.0)
        val y = Math.pow(hi, 2.0)
        val screenInches = Math.sqrt(x + y)
        return when {
            screenInches < 4 -> 3
            screenInches < 6 -> 4
            else -> 5
        }

    }
}