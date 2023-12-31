package com.example.gost_app

import Korisnik
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.release.gfg1.DBHelper


class JelovnikActivity : AppCompatActivity() {

    private lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityManager.addActivity(this)
        setContentView(R.layout.activity_jelovnik)

        val button_x : ImageButton = findViewById(R.id.button_x)
        val button_dorucak : ImageButton = findViewById(R.id.dorucak_button)
        val button_supe_i_corbe : ImageButton = findViewById(R.id.supe_i_corbe_button)
        button_dorucak.setOnClickListener {
            val intent = Intent(this@JelovnikActivity, DorucakActivity::class.java)
            startActivity(intent)
        }

        button_supe_i_corbe.setOnClickListener {
            val intent = Intent(this@JelovnikActivity, SupeICorbeActivity::class.java)
            startActivity(intent)
        }

        button_x.setOnClickListener {
            ActivityManager.finishAllExceptMain();
        }

        //BAZA
        //inicijalizacija DBHelper objekta
        dbHelper = DBHelper(this, null)

//DODAVANJE JELA U JELOVNIK ctr + .
        //Dodavanje Jela
        val omletPoZelji = Jelo(kategorija = "Doručak", nazivJela = "Omlet po želji", opis = "(suho meso, povrće, sir, gljive)", cijena = 7.0)
        val kajgana = Jelo(kategorija = "Doručak", nazivJela = "Kajgana", opis = "(3 jaja, salata, pecivo)", cijena = 5.0)
        val jajeNaOko = Jelo(kategorija = "Doručak", nazivJela = "Jaje na oko", opis = "(3 jaja, salata, pecivo)", cijena = 5.0)
        val kobasice = Jelo(kategorija = "Doručak", nazivJela = "Kobasice", opis = "(kobasice 150g, salata, pecivo, pomfrit)", cijena = 8.0)
        val ustipci = Jelo(kategorija = "Doručak", nazivJela = "Uštipci", opis = "(suho meso, sudžuka, kajmak, feta sir)", cijena = 12.0)
        val pohovaniSir = Jelo(kategorija = "Doručak", nazivJela = "Pohovani sir", cijena = 8.0)
        val brusketa = Jelo(kategorija = "Doručak", nazivJela = "Brusketa", opis = "(domaće pecivo, paradajz, mozzarela)", cijena = 10.0)

        val begovaCorba = Jelo(kategorija = "Supe i čorbe", nazivJela = "Begova čorba", cijena = 6.0)
        val madjarskiGulas = Jelo(kategorija = "Supe i čorbe", nazivJela = "Mađarski gulaš", cijena = 6.0)
        val kremSupaOdGljiva = Jelo(kategorija = "Supe i čorbe", nazivJela = "Krem supa od gljiva", cijena = 7.0)
        val govedjaSupa = Jelo(kategorija = "Supe i čorbe", nazivJela = "Goveđa supa", cijena = 4.0)

        dodajJeloUBazu(omletPoZelji)
        dodajJeloUBazu(kajgana)
        dodajJeloUBazu(jajeNaOko)
        dodajJeloUBazu(kobasice)
        dodajJeloUBazu(ustipci)
        dodajJeloUBazu(pohovaniSir)
        dodajJeloUBazu(brusketa)

        dodajJeloUBazu(begovaCorba)
        dodajJeloUBazu(madjarskiGulas)
        dodajJeloUBazu(kremSupaOdGljiva)
        dodajJeloUBazu(govedjaSupa)

//DODAVANJE NEKIH KORISNIKA
        val nadza = Korisnik(ime = "Nadža", prezime = "Memić", rodjenje = "16.08.1998", email = "nadzamemic@hotmail.com", password = "1234", tipKorisnika = TipKorisnika.GOST)
        val alisa = Korisnik(ime = "Alisa", prezime = "Brujić", rodjenje = "04.02.1998", email = "abrujic1@etfunsa.ba", password = "1234", tipKorisnika = TipKorisnika.KUHAR)



    }

    private fun dodajJeloUBazu(jelo: Jelo){
        //Pozivanje metode addJelo iz DBHelpera-a
        dbHelper.addJelo(jelo.kategorija, jelo.nazivJela, jelo.opis, jelo.cijena)

    }

}