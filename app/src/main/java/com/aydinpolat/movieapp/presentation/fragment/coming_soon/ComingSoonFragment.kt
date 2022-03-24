package com.aydinpolat.movieapp.presentation.fragment.coming_soon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.aydinpolat.movieapp.R
import com.aydinpolat.movieapp.databinding.FragmentComingSoonBinding
import com.aydinpolat.movieapp.presentation.binding_adapter.BindingFragment

class ComingSoonFragment : BindingFragment<FragmentComingSoonBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentComingSoonBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}