package com.example.addnoteswithroomdatabase.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
open class Note  {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
    var date: String = ""
    var text: String = ""

    constructor(date: String, text: String) {
        this.date = date
        this.text = text
    }
}
