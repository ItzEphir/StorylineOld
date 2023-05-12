package com.ephirium.storyline.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ephirium.storyline.R
import com.ephirium.storyline.databinding.FragmentAuthBinding
import com.google.firebase.auth.FirebaseAuth

class AuthFragment : Fragment(R.layout.fragment_auth) {

    private val binding: FragmentAuthBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(FirebaseAuth.getInstance().currentUser != null){
            findNavController().navigate(AuthFragmentDirections.actionFragmentAuthToTabGraph())
        }

        findNavController().navigate(AuthFragmentDirections.actionFragmentAuthToSignInFragment())
    }
}