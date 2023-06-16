package com.example.easyparking

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonLogin.setOnClickListener(this)
        insertToolbar()
    }

    private fun insertToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Login"
        //supportActionBar!!.title = getString(R.string.login)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.buttonLogin){
            val openHome = Intent(this, HomeActivity::class.java)
            startActivity(openHome)
        }
    }
}