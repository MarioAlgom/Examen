package com.example.aplicaccionenclase

import androidx.lifecycle.ViewModel

class TareasViewModel : ViewModel() {

    private val listaTareas = mutableListOf<String>()

    fun agregarTarea(tarea: String) {
        listaTareas.add(tarea)
    }

    fun obtenerTareas(): List<String> {
        return listaTareas.toList()
    }
}
