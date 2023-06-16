package com.example.easyparking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_credit_card.*
import kotlinx.android.synthetic.main.toolbar.*

class CreditCardActivity : AppCompatActivity(), View.OnClickListener {

    var saldo = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit_card)

        buttonFinalizar.setOnClickListener(this)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        insertToolbar()

    }

    private fun insertToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Compra Créditos"
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
        if(view.id == R.id.button1){
            saldo+= 10
            textValorCompra.setText("R$ 10,00")
        }
        if(view.id == R.id.button2){
            saldo+= 20
            textValorCompra.setText("R$ 20,00")
        }
        if(view.id == R.id.button3){
            saldo+= 30
            textValorCompra.setText("R$ 30,00")
        }
        if(view.id == R.id.button4){
            saldo+= 40
            textValorCompra.setText("R$ 40,00")
        }
        if(view.id == R.id.button5){
            saldo+= 50
            textValorCompra.setText("R$ 50,00")
        }
        if(view.id == R.id.button6){
            saldo+= 100
            textValorCompra.setText("R$ 100,00")
        }
        if(view.id == R.id.button7){
            saldo+= 200
            textValorCompra.setText("R$ 200,00")
        }
        if(view.id == R.id.button8){
            saldo+= 500
            textValorCompra.setText("R$ 500,00")
        }

        if(view.id == R.id.buttonFinalizar){
            val openCredit = Intent(this, HomeActivity::class.java)
            openCredit.putExtra("saldo", saldo)
            startActivity(openCredit)
        }
    }
}