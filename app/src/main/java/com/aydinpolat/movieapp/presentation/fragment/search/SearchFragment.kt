package com.aydinpolat.movieapp.presentation.fragment.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.aydinpolat.movieapp.R
import com.aydinpolat.movieapp.databinding.FragmentSearchBinding
import com.aydinpolat.movieapp.presentation.binding_adapter.BindingFragment


class SearchFragment : BindingFragment<FragmentSearchBinding>(){
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentSearchBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}