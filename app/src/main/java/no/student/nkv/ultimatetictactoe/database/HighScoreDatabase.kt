package no.student.nkv.ultimatetictactoe.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import java.security.AccessControlContext


@Database(entities = [Highscore::class],version = 1, exportSchema = false)
public abstract class HighscoreDatabase : RoomDatabase() {
    abstract fun HighScoreDao() : HighScoreDao

    companion object {
        @Volatile
        private var INSTANCE: HighscoreDatabase? = null

        fun getDatabase(context: Context): HighscoreDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null)
                return tempInstance

            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                    HighscoreDatabase::class.java,
                    "highscore_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}
