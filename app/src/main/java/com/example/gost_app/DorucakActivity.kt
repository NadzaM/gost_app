package com.example.gost_app

import ActivityManager
import JeloAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.release.gfg1.DBHelper

class DorucakActivity : AppCompatActivity() {

    lateinit var adapter: Adapter // Deklaracija adaptera
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityManager.addActivity(this)
        setContentView(R.layout.activity_dorucak)
        // Other initialization code for the activity
         val back_to_menu_button: Button = findViewById(R.id.button_back_to_menu)
        back_to_menu_button.setOnClickListener {
            // Ovdje možete postaviti akcije koje će se dogoditi kada se pritisne gumb
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
         }
        //BAZA
        val dbHelper = DBHelper(this, null)
        val jela = dbHelper.getJelaByKategorija("Doručak")

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = JeloAdapter(jela)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)




    }




}
