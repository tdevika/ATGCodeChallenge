package com.devika.atgcodechallenge.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devika.atgcodechallenge.data.model.Photo
import com.devika.atgcodechallenge.databinding.ItemsGalleryBinding
import com.devika.atgcodechallenge.ui.home.ImageGalleryAdapter.ImageGalleryViewHolder
import javax.inject.Inject

class ImageGalleryAdapter @Inject constructor() : ListAdapter<Photo, ImageGalleryViewHolder>(diffUtil) {


    private lateinit var callback: (String) -> Unit
    lateinit var binding: ItemsGalleryBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageGalleryViewHolder {
        binding = ItemsGalleryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageGalleryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageGalleryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun setListener(function: (String) -> Unit) {
        this.callback = function
    }


    inner class ImageGalleryViewHolder(private val binding: ItemsGalleryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Photo) {
            Glide.with(binding.root)
                .load(item?.urlS)
                .into(binding.image)

            itemView.setOnClickListener {
               callback(item.urlS)
            }
        }
    }
}

val diffUtil = object : DiffUtil.ItemCallback<Photo>() {
    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem == newItem
    }
}