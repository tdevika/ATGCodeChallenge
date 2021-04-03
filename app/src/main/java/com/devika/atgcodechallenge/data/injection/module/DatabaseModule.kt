package com.devika.atgcodechallenge.data.injection.module

import android.content.Context
import com.devika.atgcodechallenge.data.database.ImageGalleryDao
import com.devika.atgcodechallenge.data.database.ImageGalleryDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {
    @Provides
    fun provideDatabase(context: Context): ImageGalleryDatabase =
        ImageGalleryDatabase.initDatabase(context)

    @Provides
    fun provideDao(imageGalleryDatabase: ImageGalleryDatabase): ImageGalleryDao =
        imageGalleryDatabase.imageGalleryDao()
}