package com.ephirium.storyline.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ephirium.storyline.R
import com.ephirium.storyline.databinding.FragmentSignUpBinding

class SignUpFragment: Fragment(R.layout.fragment_sign_up) {

    private val binding: FragmentSignUpBinding  by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signin.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}