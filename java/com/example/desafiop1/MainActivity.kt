package com.example.desafiop1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    companion object {
        val listaItens = ArrayList<Item>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNome = findViewById<EditText>(R.id.editTextNome)
        val editTextValor = findViewById<EditText>(R.id.editTextValor)
        val editTextUrl = findViewById<EditText>(R.id.editTextUrl)
        val buttonAdicionar = findViewById<Button>(R.id.buttonAdicionar)
        val buttonVerLista = findViewById<Button>(R.id.buttonVerLista)


        buttonAdicionar.setOnClickListener {
            val nome = editTextNome.text.toString()
            val valor = editTextValor.text.toString()
            val url = editTextUrl.text.toString()

            if (nome.isNotEmpty() && valor.isNotEmpty() && url.isNotEmpty()) {
                listaItens.add(Item(nome, valor, url))
                editTextNome.text.clear()
                editTextValor.text.clear()
                editTextUrl.text.clear()
            }
        }

        buttonVerLista.setOnClickListener {
            val intent = Intent(this, ListaActivity::class.java)
            startActivity(intent)
        }
    }
}
