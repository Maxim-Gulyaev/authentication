package android.maxim.retrofitauthentication.ui

import android.maxim.myapplication.databinding.FragmentAuthBinding
import android.maxim.retrofitauthentication.model.RequestData
import android.maxim.retrofitauthentication.model.UserApi
import android.maxim.retrofitauthentication.navigator.navigator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@AndroidEntryPoint
class AuthFragment: Fragment() {

    private lateinit var binding: FragmentAuthBinding
    @Inject
    lateinit var userApi: UserApi

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
        CoroutineScope(Dispatchers.IO).launch {
            val user = userApi.auth(
                RequestData(
                    binding.tvUsername.text.toString(),
                    binding.tvPassword.text.toString()
                )
            )
            runBlocking {
                binding.apply {
                    navigator().goToUserScreen(user.firstName, user.lastName, user.image)
                }
            }
        }

    }
}