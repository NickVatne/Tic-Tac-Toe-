package no.student.nkv.ultimatetictactoe.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "highscore_table")
data class Highscore(@ColumnInfo(name = "person")
    val name: String,

    @ColumnInfo(name = "score")@PrimaryKey(autoGenerate = true)
    val score: Int = 0
)
