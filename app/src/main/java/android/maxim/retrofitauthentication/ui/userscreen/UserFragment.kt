package android.maxim.retrofitauthentication.ui.userscreen

import android.maxim.myapplication.databinding.FragmentUserBinding
import android.maxim.retrofitauthentication.navigator.navigator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

class UserFragment: Fragment() {

    private lateinit var binding: FragmentUserBinding
    private val userFragmentViewModel: UserFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserBinding.inflate(layoutInflater)

        binding.btnQuit.setOnClickListener { quit() }

        showUserData()

        return binding.root
    }

    private fun quit() {
        navigator().goToAuthScreen()
    }

    private fun showUserData() {
        userFragmentViewModel.getData()
        val firstName = userFragmentViewModel.getLiveDataInstance().value?.firstName
        val lastName = userFragmentViewModel.getLiveDataInstance().value?.lastName
        binding.tvFirstName.text = firstName.toString()
        binding.tvLastName.text = lastName.toString()
        Log.d("karamba", "userFragment.showUserData" + firstName.toString())
    }
}