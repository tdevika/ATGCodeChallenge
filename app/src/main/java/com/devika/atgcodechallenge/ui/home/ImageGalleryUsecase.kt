package com.devika.atgcodechallenge.ui.home

import com.devika.atgcodechallenge.data.model.Photo
import com.devika.atgcodechallenge.data.repository.ImageGalleryRepository
import com.devika.atgcodechallenge.utils.Results
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ImageGalleryUsecase @Inject constructor(val imageGalleryRepository: ImageGalleryRepository){
    suspend fun getPhotos(): Flow<Results<List<Photo>>> =
        withContext(Dispatchers.IO) {
            imageGalleryRepository.getPhotos()
                .map {
                    Results.Success(it)
                }
                .onStart { Results.Progress }
                .catch { e ->
                    e.message?.let { Results.Error(it) }
                }
        }
}

