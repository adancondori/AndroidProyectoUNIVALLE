package com.example.androidproyectounivalle.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.androidproyectounivalle.data.entity.Note;

import java.util.List;

/**
 * Data Access Object para la entidad Note
 */
@Dao
public interface NoteDao {

    @Query("SELECT * FROM notes ORDER BY createdAt DESC")
    List<Note> getAllNotes();

    @Query("SELECT * FROM notes WHERE id = :id")
    Note getNoteById(int id);

    @Insert
    long insertNote(Note note);

    @Update
    void updateNote(Note note);

    @Delete
    void deleteNote(Note note);

    @Query("DELETE FROM notes WHERE id = :id")
    void deleteNoteById(int id);
}
