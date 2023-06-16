package com.example.easyparking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.toolbar.*

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    var saldo = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        buttonCreditCard.setOnClickListener(this)
        buttonEstacionar.setOnClickListener(this)
        insertToolbar()

        inflateLayout()
    }

    private fun inflateLayout(){

        val status = intent.getIntExtra("status", 0)
        saldo = intent.getIntExtra("saldo", saldo)
        val placa = intent.getStringExtra("placa")
        if(status == 1){
            textContadorTempo.visibility = View.VISIBLE
            textDescativo.setText("Estacionamento Ativado para a Placa " + placa + " no dia 16/06/2023")
            saldo -= 2
            buttonEstacionar.setText("Ativar por Mais Tempo")
        }
        val saldoFormat = "R$ " + saldo.toString() + ",00"
        textSaldo.setText(saldoFormat)
    }

    private fun insertToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Home"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

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
                openCredit.putExtra("saldo", saldo)
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

    override fun onClick(view: View) {
        when(view.id){
            R.id.buttonCreditCard -> {
                val openCredit = Intent(this, CreditCardActivity::class.java)
                startActivity(openCredit)
            }
            R.id.buttonEstacionar -> {
                val openParking = Intent(this, EstacionamentoActivity::class.java)
                openParking.putExtra("saldo", saldo)
                startActivity(openParking)
            }
        }
    }
}