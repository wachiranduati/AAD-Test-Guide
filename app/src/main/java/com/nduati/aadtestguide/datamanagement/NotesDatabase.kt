package com.nduati.aadtestguide.datamanagement

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.nduati.aadtestguide.models.Notes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Notes::class], exportSchema = false, version = 1)
abstract class NotesDatabase() : RoomDatabase() {
    abstract fun notesDao() : NotesDao

    companion object{
        @Volatile
        private var INSTANCE : NotesDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope) : NotesDatabase{
            var tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotesDatabase::class.java,
                    "notes_database"
                ).addCallback(MapPlacesDatabaseCallBack(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
    public class MapPlacesDatabaseCallBack
        (private val scope: CoroutineScope) :
        RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE.let { database ->
                scope.launch {
                    if (database != null) {
                        populateDialect(database.notesDao())
                    }
                }
            }
        }

        suspend fun populateDialect(notesDao: NotesDao) {
            notesDao.addNote(Notes( "first header", "first description"))
            notesDao.addNote(Notes( "second header", "second description"))
            notesDao.addNote(Notes( "third header", "third description"))
            notesDao.addNote(Notes( "fourth header", "fourth description"))
            notesDao.addNote(Notes( "fifth header", "fifth description"))
            notesDao.addNote(Notes( "sixth header", "sixth description"))
            notesDao.addNote(Notes( "seventh header", "seventh description"))
        }


    }
}

