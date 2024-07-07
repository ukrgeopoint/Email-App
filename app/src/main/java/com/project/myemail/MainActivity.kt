package com.project.myemail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // View definition
        val emailEditText: EditText = findViewById(R.id.etEmail)
        val subjectEditText: EditText = findViewById(R.id.etSubject)
        val messageEditText: EditText = findViewById(R.id.etMessage)

        val sendButton: Button = findViewById(R.id.btnSendEmail)

        // Set listener
        sendButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val subject = subjectEditText.text.toString().trim()
            val message = messageEditText.text.toString().trim()

            // Create object intent
            val intent = Intent(Intent.ACTION_SEND)

            intent.data = Uri.parse("mailto:")
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, message)

            try {
                startActivity(Intent.createChooser(intent, "Send Email"))
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }

    }
}