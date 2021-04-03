package com.devika.atgcodechallenge.data.service

import com.devika.atgcodechallenge.data.model.ImageGalleryData
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {

    @GET("606832cf9fc4de52061cd390")
    suspend fun getPhotos(@Header("secret-key")  content_type:String = "\$2b\$10\$zeaZpSgQQirC2kJ2Sr4eSe1OAHs4hxuJuY6gOF5OxXXhn0UPA/haq"): ImageGalleryData
}

