package com.android.pransh.robokalamtask

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "portfolio")
data class Portfolio(

    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val college: String,
    val skills: String,
    val projectTitle: String,
    val projectDescription: String
)
