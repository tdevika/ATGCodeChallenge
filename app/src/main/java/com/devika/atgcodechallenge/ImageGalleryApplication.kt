package com.devika.atgcodechallenge

import android.app.Application
import com.devika.atgcodechallenge.data.injection.component.DaggerAppComponent

class ImageGalleryApplication : Application() {

    val appComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }
}