package com.example.miniprojectpaoligblan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import com.example.miniprojectpaoligblan.api.DisneyApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val imageViewGoogle = findViewById<ImageView>(R.id.imageView1)
        val imageViewGithub = findViewById<ImageView>(R.id.imageView2)
        val imageViewSpotify = findViewById<ImageView>(R.id.imageView3)
        val buttonLogin = findViewById<Button>(R.id.btnLogin)


        buttonLogin.setOnClickListener {
            val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
            val editTextPassword = findViewById<EditText>(R.id.editTextPassword)

            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                showToast("Please fill all the fields")
            } else {
                showToast("Login successful")
                val intent = Intent(this, DisneyCharacterActivity::class.java)
                startActivity(intent)
            }
        }
        imageViewGoogle.setOnClickListener {
            showToast("Connected with Google")
            val intent = Intent(this, DisneyCharacterActivity::class.java)
            startActivity(intent)
        }

        imageViewGithub.setOnClickListener {
            showToast("Connected with Github")
            val intent = Intent(this, DisneyCharacterActivity::class.java)
            startActivity(intent)
        }

        imageViewSpotify.setOnClickListener {
            showToast("Connected with Spotify")
            val intent = Intent(this, DisneyCharacterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showToast(message: String) {
        val inflater = layoutInflater
        val layout = inflater.inflate(R.layout.toast_layout, findViewById(R.id.toastTextView))

        val toastTextView = layout.findViewById<TextView>(R.id.toastTextView)
        toastTextView.text = message

        val toast = Toast(applicationContext)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layout
        toast.show()
    }
}

