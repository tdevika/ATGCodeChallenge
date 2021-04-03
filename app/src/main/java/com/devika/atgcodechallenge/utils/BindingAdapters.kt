package com.devika.atgcodechallenge.utils

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter


@BindingAdapter(value = ["setProgressState"])
fun setProgressState(
    progressBar: ProgressBar,
    uiState: UiState?
) {
    when (uiState) {
        is UiState.Progress -> progressBar.visibility = View.VISIBLE
        else -> progressBar.visibility = View.GONE
    }
}


@BindingAdapter(value = ["setErrorState"])
fun setErrorState(
    textView: TextView,
    uiState: UiState?
) {
    uiState.let {
        when (uiState) {
            is UiState.Error -> {
                textView.text = uiState.message
                textView.visibility = View.VISIBLE
            }
            else -> textView.visibility = View.GONE
        }
    }
}
