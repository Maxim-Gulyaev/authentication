package android.maxim.retrofitauthentication.ui.userscreen

import android.maxim.myapplication.databinding.FragmentUserBinding
import android.maxim.retrofitauthentication.navigator.navigator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class UserFragment: Fragment() {

    private lateinit var binding: FragmentUserBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserBinding.inflate(layoutInflater)

        binding.btnQuit.setOnClickListener { quit() }

        return binding.root
    }

    private fun quit() {
        navigator().goToAuthScreen()
    }
}