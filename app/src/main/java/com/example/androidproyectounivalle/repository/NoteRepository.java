package com.example.androidproyectounivalle.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.example.androidproyectounivalle.data.database.AppDatabase;
import com.example.androidproyectounivalle.data.entity.Note;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Repositorio que maneja las operaciones de la base de datos
 */
public class NoteRepository {

    private final AppDatabase database;
    private final ExecutorService executorService;

    public NoteRepository(Context context) {
        database = AppDatabase.getInstance(context);
        executorService = Executors.newSingleThreadExecutor();
    }

    // Interfaz para manejar callbacks asíncronos
    public interface DataCallback<T> {
        void onDataLoaded(T data);
    }

    // Obtener todas las notas
    public void getAllNotes(DataCallback<List<Note>> callback) {
        executorService.execute(() -> {
            List<Note> notes = database.noteDao().getAllNotes();
            callback.onDataLoaded(notes);
        });
    }

    // Obtener nota por ID
    public void getNoteById(int id, DataCallback<Note> callback) {
        executorService.execute(() -> {
            Note note = database.noteDao().getNoteById(id);
            callback.onDataLoaded(note);
        });
    }

    // Insertar nota
    public void insertNote(Note note, DataCallback<Long> callback) {
        executorService.execute(() -> {
            long id = database.noteDao().insertNote(note);
            callback.onDataLoaded(id);
        });
    }

    // Actualizar nota
    public void updateNote(Note note) {
        executorService.execute(() -> {
            database.noteDao().updateNote(note);
        });
    }

    // Eliminar nota
    public void deleteNote(Note note) {
        executorService.execute(() -> {
            database.noteDao().deleteNote(note);
        });
    }

    // Eliminar nota por ID
    public void deleteNoteById(int id) {
        executorService.execute(() -> {
            database.noteDao().deleteNoteById(id);
        });
    }
}
