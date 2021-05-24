package com.simranjeetsingh05.symplywrite_v1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Note::class), version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {


    abstract fun getNoteDao(): NoteDao

    companion object{

        @Volatile           //for immediate visibilty of data
        private var INSTANCE: NoteDatabase? = null //for having a single instance of a class(Singleton class)

        fun getDatabase(context: Context): NoteDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) { //protected from concurrent execution
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase ::class.java,
                    "note_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}