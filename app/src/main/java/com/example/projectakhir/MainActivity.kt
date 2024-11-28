package com.example.projectakhir

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvKeluargaB2E: RecyclerView
    private val list = ArrayList<Anggota>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Untuk status bar transparan
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Color.TRANSPARENT
        }

        // Untuk mengatur teks status bar agar terlihat
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        rvKeluargaB2E = findViewById(R.id.rv_keluargaB2E)
        rvKeluargaB2E.setHasFixedSize(true)
        list.addAll(getListHeroes())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_about-> {
                val intent = Intent(this,ProfilAbout::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getListHeroes(): ArrayList<Anggota> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listB2E = ArrayList<Anggota>()
        for (i in dataName.indices) {
            val hero = Anggota(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listB2E.add(hero)
        }
        return listB2E
    }

    private fun showRecyclerList() {
        rvKeluargaB2E.layoutManager = LinearLayoutManager(this)
        val listB2EAdapter = ListB2EAdapter(list)
        rvKeluargaB2E.adapter = listB2EAdapter
    }
}