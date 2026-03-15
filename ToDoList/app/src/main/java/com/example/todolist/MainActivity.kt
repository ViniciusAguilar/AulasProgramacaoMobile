package com.example.todolist

import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.AdapterView

class MainActivity : AppCompatActivity() {
    private lateinit var editTask: EditText
    private lateinit var btnAdd: Button
    private lateinit var listTasks: ListView

    private val tarefas = ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        editTask = findViewById<EditText>(R.id.editText_tarefa)
        btnAdd = findViewById<Button>(R.id.button)
        listTasks = findViewById<ListView>(R.id.lista)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tarefas)
        listTasks.adapter = adapter

        btnAdd.setOnClickListener {
            val tarefa = editTask.text.toString()

            if (tarefa.isNotEmpty()){
                tarefas.add(tarefa)
                adapter.notifyDataSetChanged()
                editTask.text.clear()
            }else{
                Toast.makeText(this,"Digite uma tarefa!", Toast.LENGTH_SHORT).show()
            }
        }

        listTasks.setOnItemClickListener { _, _, position, _ ->
            tarefas.removeAt(position)
            adapter.notifyDataSetChanged()
        }
    }
}