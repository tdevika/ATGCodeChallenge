package com.devika.atgcodechallenge.data.injection.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devika.atgcodechallenge.data.injection.scope.ViewModelScope
import com.devika.atgcodechallenge.ui.home.ImageGalleryViewModel
import com.devika.atgcodechallenge.utils.ImageGalleryViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {
    @Binds
    abstract fun provideViewModelFactory(imageGalleryViewModelFactory: ImageGalleryViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelScope(ImageGalleryViewModel::class)
    abstract fun bindImageGalleryViewModel(imageGalleryViewModel: ImageGalleryViewModel): ViewModel
}