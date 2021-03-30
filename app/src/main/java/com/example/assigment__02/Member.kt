package com.example.assigment__02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.textView
import kotlinx.android.synthetic.main.activity_member.*

class Member : AppCompatActivity() {
    var auth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member)

        auth= FirebaseAuth.getInstance()
        val userData = auth!!.currentUser
        textView.text = userData?.uid.toString()+" "+ userData!!.email

        Logout.setOnClickListener {
            auth!!.signOut()
            Toast.makeText(this,"Logout ออกจากระบบแล้ว", Toast.LENGTH_LONG).show()
            val it = Intent(this, MainActivity::class.java)
            startActivity(it)
            finish()
        }

    }
}