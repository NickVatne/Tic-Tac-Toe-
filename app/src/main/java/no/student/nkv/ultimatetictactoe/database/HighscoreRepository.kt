package no.student.nkv.ultimatetictactoe.database

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread

class PersonRepository(private val HighScoreDao: HighScoreDao) {

    val allHighscoreLive: LiveData<List<Highscore>> = HighScoreDao.getAllScoresLive()

    @WorkerThread
    suspend fun insert(score: Highscore) {
        HighScoreDao.insert(score)
    }
    @WorkerThread
    suspend fun deleteAll() {
        HighScoreDao.deleteAll()
    }
}