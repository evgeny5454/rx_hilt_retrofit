package com.evgeny5454.rx_retrofit.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.RequestManager
import com.evgeny5454.rx_retrofit.databinding.FragmentPictureBinding
import com.evgeny5454.rx_retrofit.presentation.view_model.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PictureFragment : Fragment() {

    private lateinit var binding: FragmentPictureBinding
    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var glide : RequestManager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPictureBinding.inflate(layoutInflater)

        viewModel.picture.observe(viewLifecycleOwner) { item ->

            glide.load(item.url).into(binding.imageView)
            binding.text.text = item.explanation
        }
        return binding.root
    }
}