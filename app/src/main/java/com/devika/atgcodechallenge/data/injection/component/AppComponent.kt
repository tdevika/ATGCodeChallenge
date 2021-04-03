package com.devika.atgcodechallenge.data.injection.component

import android.content.Context
import com.devika.atgcodechallenge.data.injection.module.DatabaseModule
import com.devika.atgcodechallenge.data.injection.module.NetWorkModule
import com.devika.atgcodechallenge.data.injection.module.ViewModelModule
import com.devika.atgcodechallenge.ui.home.ImageGalleryFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [NetWorkModule::class,ViewModelModule::class,DatabaseModule::class])
interface AppComponent {
    fun inject(imageGalleryFragment: ImageGalleryFragment)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context):AppComponent
    }
}