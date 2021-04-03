package com.devika.atgcodechallenge.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class ImageGalleryData(
    val photos: Photos,
    val stat: String
)

data class Photos(
    @PrimaryKey val page: Int,
    val pages: Int,
    val perpage: Int,
    val photo: List<Photo>,
    val total: Int
)

@Entity(tableName = "image_gallery_data")
data class Photo(
    val farm: Int,
    @SerializedName("height_s")
    val heightS: Int,
    @PrimaryKey val id: String,
    val isfamily: Int,
    val isfriend: Int,
    val ispublic: Int,
    val owner: String,
    val secret: String,
    val server: String,
    val title: String,
    @SerializedName("url_s")
    val urlS: String,
    @SerializedName("width_s")
    val widthS: Int
)