package com.devika.atgcodechallenge.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.devika.atgcodechallenge.ImageGalleryApplication
import com.devika.atgcodechallenge.R
import com.devika.atgcodechallenge.databinding.FragmentImageGalleryBinding
import com.devika.atgcodechallenge.ui.photo.PhotoFragment
import com.devika.atgcodechallenge.utils.ImageGalleryViewModelFactory
import com.devika.atgcodechallenge.utils.UiState
import com.devika.atgcodechallenge.utils.getList
import javax.inject.Inject

class ImageGalleryFragment : Fragment() {

    lateinit var galleryViewModel: ImageGalleryViewModel

    @Inject
    lateinit var imageGalleryViewModelFactory: ImageGalleryViewModelFactory

    @Inject
    lateinit var imageGalleryAdapter: ImageGalleryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().applicationContext as ImageGalleryApplication).appComponent.inject(this)
    }

    lateinit var binding: FragmentImageGalleryBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentImageGalleryBinding>(
            inflater,
            R.layout.fragment_image_gallery,
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setRecyclerView()
        setObserver()
         }

    private fun setObserver() {
        galleryViewModel.uiState.observe(viewLifecycleOwner, Observer {
            if (it is UiState.Success) {
                imageGalleryAdapter.submitList(it.value.getList())
            }
        })
        imageGalleryAdapter.setListener { url: String ->
            findNavController().navigate(ImageGalleryFragmentDirections.actionImageGalleryFragmentToPhotoFragment(url))
        }

    }


    private fun setRecyclerView() {
        binding.recyclerView.apply {
            val manager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
            layoutManager = manager
            adapter = imageGalleryAdapter
        }
    }

    private fun setupViewModel() {
        galleryViewModel =
            ViewModelProvider(
                this,
                imageGalleryViewModelFactory
            ).get(ImageGalleryViewModel::class.java)
        binding.viewModel = galleryViewModel
    }
}