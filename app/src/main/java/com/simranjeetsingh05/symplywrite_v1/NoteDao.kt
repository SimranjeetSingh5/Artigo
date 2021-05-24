package com.simranjeetsingh05.symplywrite_v1


import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE) //Non repeating notes or sentences
    suspend fun insert(note: Note) //suspend to use at background because of  heavy io operation

    @Delete //Deletes the note
    suspend fun delete(note: Note)//suspend to use at background because of  heavy io operation

    @Query("Select * from notes_table order by id ASC") //Shows all the data using livedata
    fun getAllNotes():LiveData<List<Note>>


    //suspend is part of kotlin coroutines
}