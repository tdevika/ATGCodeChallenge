package com.devika.atgcodechallenge.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devika.atgcodechallenge.utils.Results
import com.devika.atgcodechallenge.utils.UiState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class ImageGalleryViewModel @Inject constructor(private val imageGalleryUsecase: ImageGalleryUsecase) : ViewModel(){
    val uiState = MutableLiveData<UiState>()

    init {
        getPhotos()
    }

    private fun getPhotos() {
        viewModelScope.launch {
            imageGalleryUsecase.getPhotos().collectLatest {
                when (it) {
                    is Results.Success -> uiState.value = UiState.Success(it.value)
                    is Results.Error -> uiState.value = UiState.Error(it.message)
                    is Results.Progress -> uiState.value = UiState.Progress
                }
            }

        }
    }
}