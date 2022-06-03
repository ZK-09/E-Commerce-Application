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

class SignUp : AppCompatActivity() {

    private lateinit var editTextUsername : EditText    //Username in Login Page
    private lateinit var editTextPassword : EditText    //Password in Login Page
    private lateinit var btnSignUp : Button   //Login Button

    //ActionBar
    private lateinit var actionBar : ActionBar

    //ProgressDialog
    private lateinit var progressDialog: ProgressDialog

    //Firebase Authentical
    private lateinit var firebaseAuth: FirebaseAuth

    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)    //R.layout.activity_sign_up

        editTextUsername = findViewById(R.id.editTextUsernameSU)
        editTextPassword = findViewById(R.id.editTextPasswordSU)
        btnSignUp = findViewById(R.id.buttonSignUp)

        actionBar = supportActionBar!!
        actionBar.title = "Sign Up"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        //Configure progress dialog
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please Wait")
        progressDialog.setMessage("Creating Account...")
        progressDialog.setCanceledOnTouchOutside(false)

        firebaseAuth = FirebaseAuth.getInstance()

        //handler button
        btnSignUp.setOnClickListener {
            //Validate data
            validDate()
        }

    }

    private fun validDate() {
        //Get Data
        email = editTextUsername.text.toString().trim()
        password = editTextPassword.text.toString().trim()

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            //Invalid
            editTextUsername.error = "Invalid Email Format"
        } else if (TextUtils.isEmpty(password)){
            editTextPassword.error = "Please Enter Password"

        } else if (password.length < 5) {
            editTextPassword.error = "Password must at least 5 characters long"

        } else {
            SignUpFireBase()
        }
    }

    private fun SignUpFireBase() {
        progressDialog.show()

        //Create Account
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
               //Sign Up Good
                val user = firebaseAuth.currentUser
                val email = user!!.email
                progressDialog.dismiss()
                Toast.makeText(this, "Account $email has been created", Toast.LENGTH_SHORT).show()

                //Open Home Page
                startActivity(Intent(this, HomePage::class.java ))

                finish()
            }
            .addOnFailureListener { e->
                //Sign Up Failed
                progressDialog.dismiss()
                Toast.makeText(this, "Sign Up Failed ${e.message}", Toast.LENGTH_LONG).show()
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()

        return super.onSupportNavigateUp()
    }
}