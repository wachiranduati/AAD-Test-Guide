package com.nduati.aadtestguide.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes_table")
data class Notes (
    @ColumnInfo()
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    @ColumnInfo()
    val header : String,
    @ColumnInfo()
    val desc : String)