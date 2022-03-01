package com.example.addnoteswithroomdatabase.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.addnoteswithroomdatabase.MyApplication
import com.example.addnoteswithroomdatabase.R
import com.example.addnoteswithroomdatabase.adapter.NoteAdapter
import com.example.addnoteswithroomdatabase.database.NoteRepository
import com.example.addnoteswithroomdatabase.helper.NoteDialog
import com.example.addnoteswithroomdatabase.model.Note
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    companion object {
        var notes = MyApplication.notes
        var adapter = NoteAdapter(notes)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager= GridLayoutManager(this,1)
        recyclerView.adapter= adapter
        val add = findViewById<FloatingActionButton>(R.id.add_fab)
        add.setOnClickListener {
            val dialog = NoteDialog(this)
            dialog.show()
        }

    }
}