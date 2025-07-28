package com.andikas.nativestarter.core.data.source.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.andikas.nativestarter.core.data.source.local.database.dao.ExampleDao
import com.andikas.nativestarter.core.data.source.local.database.entity.ExampleEntity

@Database(
    entities = [
        ExampleEntity::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun exampleDao(): ExampleDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        private val lock = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app_database.db"
                    ).fallbackToDestructiveMigration().build()
                }
                return INSTANCE!!
            }
        }
    }
}