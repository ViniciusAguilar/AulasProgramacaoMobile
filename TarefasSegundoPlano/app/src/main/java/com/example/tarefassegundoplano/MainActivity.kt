package com.example.tarefassegundoplano

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var  edtNota: EditText
    private lateinit var  btnSalvar: Button
    lateinit var txtStatus: TextView

    lateinit var db: NoteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        edtNota = findViewById<EditText>(R.id.edNota)
        btnSalvar = findViewById<Button>(R.id.bntSalvar)
        txtStatus = findViewById<TextView>(R.id.txtStatus)

        db = Room.databaseBuilder(applicationContext,
            NoteDatabase::class.java,"notes_db").build()
        /*
        btnSalvar.setOnClickListener {
            val texto = edtNota.text.toString()

            if (texto.isNotEmpty()){
                SaveNoteTask(this, texto).execute()

            }else{
                txtStatus.text = "digite uma nota"
            }
        }
        */
        btnSalvar.setOnClickListener {
            val texto = edtNota.text.toString()

            if (texto.isNotEmpty()) {
                saveNoteWithCoroutines(texto)
            } else {
                txtStatus.text = "Digite uma nota."
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun saveNoteWithCoroutines(noteText: String) {
        txtStatus.text = "Salvando nota..."

        GlobalScope.launch(Dispatchers.IO) {
            val sucesso = try {
                val note = Note(text = noteText)
                db.noteDao().insert(note)
                true
            } catch (e: Exception) {
                false
            }

            withContext(Dispatchers.Main) {
                if (sucesso) {
                    txtStatus.text = "Nota salva com sucesso!"
                } else {
                    txtStatus.text = "Erro ao salvar a nota."
                }
            }
        }
    }

}