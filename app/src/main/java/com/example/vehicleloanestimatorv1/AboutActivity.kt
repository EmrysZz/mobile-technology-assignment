package com.example.vehicleloanestimatorv1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView // or Button, depending on what you used
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val tvGithubLink = findViewById<TextView>(R.id.tvGithubLink)
        val btnBack = findViewById<ImageButton>(R.id.btnBack)

        //Add Back Logic
        btnBack.setOnClickListener {
            finish()
        }

        // Requirement: Clickable GitHub Repository URL [cite: 47]
        tvGithubLink.setOnClickListener {
            val url = "https://github.com/EmrysZz/mobile-technology-assignment.git" // Replace this!
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }
}