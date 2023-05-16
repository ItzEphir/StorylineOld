package com.ephirium.storyline.ui.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ephirium.common.listener.DataConstListener
import com.ephirium.common.listener.ErrorListener
import com.ephirium.common.log.log
import com.ephirium.common.log.logError
import com.ephirium.data.repository.LoadedUserRepository
import com.ephirium.data.storage.UserDto
import com.ephirium.domain.usecase.LoadedUserUseCase
import com.ephirium.storyline.R
import com.ephirium.storyline.databinding.FragmentAuthBinding
import com.google.firebase.auth.FirebaseAuth
import java.lang.Exception

class AuthFragment : Fragment(R.layout.fragment_auth) {

    private val binding: FragmentAuthBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        log("Auth")

        if (FirebaseAuth.getInstance().currentUser != null) {

            val loadedUserUseCase = LoadedUserUseCase(LoadedUserRepository())

            loadedUserUseCase.observeUser(
                FirebaseAuth.getInstance().currentUser!!.email.toString(),
                object : DataConstListener<UserDto> {
                    override fun onChange(value: UserDto) {
                        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
                        with(sharedPref.edit()) {
                            putString(getString(R.string.saved_user_key), value.id)
                        }
                    }
                },
                object : ErrorListener {
                    override fun onError(exception: Exception) {
                        this logError exception.toString()
                    }
                })

            findNavController().navigate(AuthFragmentDirections.actionFragmentAuthToTabGraph())
        }

        findNavController().navigate(AuthFragmentDirections.actionFragmentAuthToSignInFragment())
    }
}