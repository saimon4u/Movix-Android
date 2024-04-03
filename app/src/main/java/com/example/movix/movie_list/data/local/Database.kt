package com.example.movix.movie_list.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MovieEntity::class, ShowEntity::class],
    version = 1
)
abstract class Database: RoomDatabase() {
    abstract val dao: Dao
}