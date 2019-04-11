package no.student.nkv.ultimatetictactoe.database

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext



class HighscoreModel(application: Application) :AndroidViewModel(application) {
    private val  repository: PersonRepository
    val allHighscore: LiveData<List<Highscore>>
    //co-routine
    private var parentJob = Job()
    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)

    init {
        val personDAO = HighscoreDatabase.getDatabase(application.applicationContext)
            .HighScoreDao()
        repository = PersonRepository(personDAO)
        allHighscore = repository.allHighscoreLive
    }

    fun insert(Highscore: Highscore) = scope.launch(Dispatchers.IO) {
        repository.insert(Highscore)
    }

    fun delete() = scope.launch(Dispatchers.IO) {
        repository.deleteAll()
    }
}