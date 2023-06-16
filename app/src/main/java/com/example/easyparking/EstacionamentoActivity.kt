package com.example.easyparking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_estacionamento.*
import kotlinx.android.synthetic.main.toolbar.*

class EstacionamentoActivity : AppCompatActivity(), View.OnClickListener{

    var saldo = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estacionamento)
        insertToolbar()

        buttonAddEstaciona.setOnClickListener(this)
        buttonCancelar.setOnClickListener(this)

        placaOne.setOnClickListener(this)
        placaTwo.setOnClickListener(this)

        saldo = intent.getIntExtra("saldo", saldo)
    }

    private fun insertToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Estacionamento"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        //supportActionBar!!.title = getString(R.string.login)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menuSituacaoAtual -> {
                val openCredit = Intent(this, HomeActivity::class.java)
                startActivity(openCredit)
            }
            R.id.menuCompraCredito -> {
                val openCredit = Intent(this, CreditCardActivity::class.java)
                startActivity(openCredit)
            }
            R.id.menuEstacionamento -> {
                val openCredit = Intent(this, EstacionamentoActivity::class.java)
                startActivity(openCredit)
            }
            else -> {
                onBackPressed()
            }
        }
        return true
    }

    var placa = ""

    override fun onClick(view: View) {
        if(view.id == R.id.buttonCancelar){
            val openCredit = Intent(this, HomeActivity::class.java)
            startActivity(openCredit)
        }
        if(view.id == R.id.placaOne){
            placaOne.setBackgroundResource(R.drawable.button_blue_border)
            placa = textPLacaOne.text.toString()
        }
        if(view.id == R.id.placaTwo){
            placaTwo.setBackgroundResource(R.drawable.button_blue_border)
            placa = textPLacaTwo.text.toString()
        }
        if(view.id == R.id.buttonAddEstaciona){
            val openHome = Intent(this, HomeActivity::class.java)
            openHome.putExtra("status", 1)
            openHome.putExtra("saldo", saldo)
            openHome.putExtra("placa", placa)
            startActivity(openHome)
        }
    }
}