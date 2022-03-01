package com.example.addnoteswithroomdatabase.helper

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import android.widget.EditText
import android.widget.TextView
import com.example.addnoteswithroomdatabase.R
import com.example.addnoteswithroomdatabase.activity.MainActivity
import com.example.addnoteswithroomdatabase.database.NoteRepository
import com.example.addnoteswithroomdatabase.model.Note
import java.text.SimpleDateFormat

import java.util.*
import java.util.concurrent.Executors

class NoteDialog(var a:Activity):Dialog(a) {
    private lateinit var et_dialog:EditText
    private lateinit var tv_add:TextView
    private lateinit var tv_cancel:TextView
    private lateinit var date:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.item_dialog)
        initViews()
        setCancelable(true)
    }

    private fun initViews() {
        et_dialog = findViewById(R.id.et_dialog)
        tv_add = findViewById(R.id.tv_save)
        tv_cancel = findViewById(R.id.tv_cancel)
        tv_cancel.setOnClickListener {
            et_dialog.setText("")
            dismiss()
        }
        tv_add.setOnClickListener {
            val simpleDateFormat = SimpleDateFormat("dd-MM-yyyy HH:MM:SS")
            val date = simpleDateFormat.format(Date())
            val note = Note(date, et_dialog.text.toString())
            noteExacutor(NoteRepository(a.application),note)
            dismiss()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun noteExacutor(repository: NoteRepository, note:Note) {
        val exacutor= Executors.newSingleThreadExecutor()
        val handler= Handler(Looper.getMainLooper())
        exacutor.execute{
            repository.saveNote(note)
            MainActivity.notes.add(note)
            handler.post {
                MainActivity.adapter.notifyDataSetChanged()
            }
        }


    }
}