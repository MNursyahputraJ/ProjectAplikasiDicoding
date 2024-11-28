package com.example.projectakhir

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView


class DetailAnggota : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_anggota)

        // Untuk status bar transparan
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Color.TRANSPARENT
        }

        // Untuk mengatur teks status bar agar terlihat
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        // Ambil data dari intent
        val name = intent.getStringExtra(EXTRA_NAME)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)
        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)

        // Hubungkan view dengan data
        val imgPhoto: ImageView = findViewById(R.id.img_detail_photo)
        val tvName: TextView = findViewById(R.id.tv_detail_name)
        val tvDescription: TextView = findViewById(R.id.tv_detail_description)

        imgPhoto.setImageResource(photo)
        tvName.text = name
        tvDescription.text = description

    }
        companion object {
            const val EXTRA_NAME = "extra_name"
            const val EXTRA_DESCRIPTION = "extra_description"
            const val EXTRA_PHOTO = "extra_photo"
        }

}