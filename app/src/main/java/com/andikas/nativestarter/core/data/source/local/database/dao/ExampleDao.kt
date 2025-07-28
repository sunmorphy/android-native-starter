package com.andikas.nativestarter.core.data.source.local.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.andikas.nativestarter.core.data.source.local.database.entity.ExampleEntity

@Dao
interface ExampleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExample(example: ExampleEntity): Long

    @Query("SELECT * FROM example ORDER BY id ASC")
    suspend fun getListExample(): List<ExampleEntity>?

    @Query("SELECT * FROM example WHERE id = :id")
    suspend fun getExample(id: Long): ExampleEntity?

    @Delete
    suspend fun deleteExample(example: ExampleEntity)

    @Query("DELETE FROM example")
    suspend fun clearExample()
}