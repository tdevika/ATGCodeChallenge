package com.devika.atgcodechallenge.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.devika.atgcodechallenge.data.model.Photo
import com.devika.atgcodechallenge.data.model.Photos

@Database(entities = [Photo::class], version = 1, exportSchema = false)
abstract class ImageGalleryDatabase() : RoomDatabase() {
    abstract fun imageGalleryDao(): ImageGalleryDao

    companion object {
        @Volatile
        var INSTANCE: ImageGalleryDatabase? = null

        fun initDatabase(context: Context): ImageGalleryDatabase {
            var instance = INSTANCE
            if (instance == null) {
                instance = synchronized(this) {
                    Room.databaseBuilder(
                        context,
                        ImageGalleryDatabase::class.java,
                        "image_gallery_database"
                    ).fallbackToDestructiveMigration().build()
                }
                INSTANCE = instance
            }
            return instance
        }
    }
}