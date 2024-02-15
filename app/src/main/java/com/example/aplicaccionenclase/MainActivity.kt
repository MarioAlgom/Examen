package com.example.aplicaccionenclase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var etTitulo: EditText
    lateinit var etDescripcion: EditText
    lateinit var btnAceptar: Button
    lateinit var listaElementos: ListView
    val elementos = mutableListOf<String>()

    private val tareasViewModel:TareasViewModel by viewmodels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etTitulo = findViewById(R.id.etTitulo)
        etDescripcion = findViewById(R.id.etDescripcion)
        btnAceptar = findViewById(R.id.btnAceptar)
        listaElementos = findViewById(R.id.lvElementos)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, elementos)
        listaElementos.adapter = adapter

        btnAceptar.setOnClickListener {
            val titulo = etTitulo.text.toString()
            val desc = etDescripcion.text.toString()
            val textoF = "$titulo -~- $desc"

            elementos.add(textoF)
            adapter.notifyDataSetChanged()
            Toast.makeText(this, "Elemento agregado: $textoF", Toast.LENGTH_SHORT).show()

            // Limpiar campos de texto después de agregar
            etTitulo.text.clear()
            etDescripcion.text.clear()
        }
    }
}
