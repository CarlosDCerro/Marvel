package com.example.marvel.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.marvel.data.database.dao.MovieCharacterDao
import com.example.marvel.data.database.entity.MovieCharacterEntity

@Database(
    entities = [MovieCharacterEntity::class],
    version = 1
)
abstract class DataBase: RoomDatabase() {
    abstract fun characterDao(): MovieCharacterDao

    /*companion object {
        private var INSTANCE: DataBase? = null

        fun getIntance(context: Context): DataBase {
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DataBase::class.java,
                        "CharacteresDB"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }*/
}