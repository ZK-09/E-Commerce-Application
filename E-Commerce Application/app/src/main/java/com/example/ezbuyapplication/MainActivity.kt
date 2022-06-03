package com.example.ezbuyapplication

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.example.ezbuyapplication.home_page.HomePage
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    //Variable
    private lateinit var editTextUsername : EditText    //Username in Login Page
    private lateinit var editTextPassword : EditText    //Password in Login Page
    private lateinit var btnLogin : Button   //Login Button
    private lateinit var btnRegister : Button //Register Button

    //Action Bar
    private lateinit var actionBar: ActionBar

    //ProgressDialog
    private lateinit var progressDialog: ProgressDialog

    //Firebase Auth
    private lateinit var firebaseAuth: FirebaseAuth

    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)    //R.layout.activity_main

        editTextUsername = findViewById(R.id.editTextUsername)
        editTextPassword = findViewById(R.id.editTextPassword)
        btnLogin = findViewById(R.id.buttonLogin)
        btnRegister = findViewById(R.id.buttonRegister)

        //configure actionbar
        actionBar = supportActionBar!!
        actionBar.title = "Login"

        //Configure progress dialog
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please Wait")
        progressDialog.setMessage("Logging In...")
        progressDialog.setCanceledOnTouchOutside(false)

        //init firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance()

        btnRegister.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))
        }

        //Login Button Handler
        btnLogin.setOnClickListener {
            //before logging in must valid data
            validDate()
        }

    }

    private fun validDate() {
        //get data
        email = editTextUsername.text.toString().trim()
        password = editTextPassword.text.toString().trim()

        //validate data
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){      //Invalid email format
            editTextUsername.error = "Invalid email format"

        } else if (TextUtils.isEmpty(password)){
            editTextPassword.error = "Please Enter Password"

        } else {
            Login()

        }
    }

    private fun Login() {
        progressDialog.show()
        firebaseAuth.signInWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                progressDialog.dismiss()

                //get user info
                val user = firebaseAuth.currentUser
                val email = user!!.email


                Toast.makeText(this, "Logged In as $email", Toast.LENGTH_SHORT).show()

                startActivity(Intent(this, HomePage::class.java ))

                finish()
        }
            .addOnFailureListener{ e->
                //Failed Login
                progressDialog.dismiss()
                Toast.makeText(this, "Login Failed ${e.message}", Toast.LENGTH_LONG).show()
            }
    }

}


