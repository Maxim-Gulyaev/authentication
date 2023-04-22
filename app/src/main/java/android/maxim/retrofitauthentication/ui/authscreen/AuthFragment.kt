package android.maxim.retrofitauthentication.ui.authscreen

import android.maxim.myapplication.databinding.FragmentAuthBinding
import android.maxim.retrofitauthentication.navigator.navigator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

class AuthFragment: Fragment() {

    private lateinit var binding: FragmentAuthBinding
    private val authViewModel: AuthFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthBinding.inflate(layoutInflater)

        binding.btnEnter.setOnClickListener { enter() }

        return binding.root
    }

    private fun enter() {
        navigator().goToUserScreen()
    }

}