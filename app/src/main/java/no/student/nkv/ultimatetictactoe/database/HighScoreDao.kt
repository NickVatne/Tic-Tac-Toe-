package no.student.nkv.ultimatetictactoe.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

interface HighScoreDao{

    @Insert
    fun insert(name: Highscore)


    @Delete
    fun delete(name: Highscore)

    @Query("DELETE FROM highscore_table")
    fun deleteAll()

    /*@Query("INSERT INTO age VALUES ("")")
    fun insert()*/

    @Query("SELECT * FROM highscore_table")
    fun getAllScoresLive() : LiveData<List<Highscore>>

    @Query("SELECT * FROM highscore_table")
    fun getAllSCores() : List<Highscore>




}