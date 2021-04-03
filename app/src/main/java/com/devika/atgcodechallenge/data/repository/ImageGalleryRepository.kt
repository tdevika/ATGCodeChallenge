package com.devika.atgcodechallenge.data.repository

import com.devika.atgcodechallenge.data.database.ImageGalleryDao
import com.devika.atgcodechallenge.data.model.Photo
import com.devika.atgcodechallenge.data.service.ApiService
import com.devika.atgcodechallenge.utils.NetworkManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ImageGalleryRepository @Inject constructor(
    private val imageGalleryDao: ImageGalleryDao,
    private val apiService: ApiService,
    val networkManager: NetworkManager
) {
    suspend fun getPhotos(): Flow<List<Photo>> {
        if (networkManager.isNetworkAvailable()) {
            val photosList = apiService.getPhotos().photos.photo
            imageGalleryDao.insertImageGalleryData(photosList)
        }
        return imageGalleryDao.getPhotos()
    }
}