package com.example.gost_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.release.gfg1.DBHelper


class MainActivity : AppCompatActivity() {

    private lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        ActivityManager.addActivity(this)
        setContentView(R.layout.activity_main)

        val goButton: Button = findViewById(R.id.goButton)
        val email: EditText = findViewById(R.id.editTextTextEmailAddress)
        val password: EditText = findViewById(R.id.editTextTextPassword)

        goButton.setOnClickListener {
            //  val unesenaLozinka = password.text.toString()

            // Pristupite DBHelper klasi
            // val dbHelper = DBHelper(this, null)

            //val korisnik = dbHelper.nadjiKorisnikaPoEmailu(email.toString())

// Provjerite dobivene podatke o korisniku
            //  Log.d(
            //    "Korisnik",
            //   korisnik ?: "Korisnik nije pronađen"
            //) // Ovo će ispisati podatke korisnika ili poruku ako korisnik nije pronađen

            //  }

            // fun provjeriPassword(unijetaLozinka: String, email: String): Boolean {

            //   if(unijetaLozinka == "1234") return true
            // else return false
            // }
            val intent = Intent(this@MainActivity, JelovnikActivity::class.java)
            startActivity(intent)

        }
    }
}