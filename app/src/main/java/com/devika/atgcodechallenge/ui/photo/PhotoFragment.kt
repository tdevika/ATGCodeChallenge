package com.devika.atgcodechallenge.ui.photo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.devika.atgcodechallenge.databinding.FragmentPhotoBinding

class PhotoFragment : Fragment() {
    lateinit var binding: FragmentPhotoBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhotoBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val photoUrl = PhotoFragmentArgs.fromBundle(requireArguments()).photo
        Glide.with(this)
            .load(photoUrl)
            .into(binding.photo)
    }
}