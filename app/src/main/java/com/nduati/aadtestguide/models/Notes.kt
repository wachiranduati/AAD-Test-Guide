package com.nduati.aadtestguide.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes_table")
data class Notes (
    val header : String,
    val desc : String){
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}