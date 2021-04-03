package com.devika.atgcodechallenge.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.devika.atgcodechallenge.data.model.Photo
import kotlinx.coroutines.flow.Flow

@Dao
interface ImageGalleryDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertImageGalleryData(photo: List<Photo>)

    @Query("select * from image_gallery_data")
    fun getPhotos(): Flow<List<Photo>>

}