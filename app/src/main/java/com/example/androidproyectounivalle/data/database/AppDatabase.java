package com.example.androidproyectounivalle.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.androidproyectounivalle.data.dao.NoteDao;
import com.example.androidproyectounivalle.data.entity.Note;

/**
 * Base de datos principal de la aplicación
 */
@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "notes_db";

    // Instancia singleton
    private static AppDatabase instance;

    // DAO
    public abstract NoteDao noteDao();

    // Método singleton para obtener la instancia de la base de datos
    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
