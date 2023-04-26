package android.maxim.retrofitauthentication.ui.authscreen

import android.maxim.myapplication.databinding.FragmentAuthBinding
import android.maxim.retrofitauthentication.model.RequestData
import android.maxim.retrofitauthentication.model.UserApi
import android.maxim.retrofitauthentication.navigator.navigator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AuthFragment: Fragment() {

    private lateinit var binding: FragmentAuthBinding
    private val authViewModel: AuthFragmentViewModel by viewModels()
    lateinit var retrofit: Retrofit
    lateinit var userApi: UserApi

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthBinding.inflate(layoutInflater)

        binding.btnEnter.setOnClickListener { enter() }

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        userApi = retrofit.create(UserApi::class.java)

        return binding.root
    }

    private fun enter() {
        //navigator().goToUserScreen()
        CoroutineScope(Dispatchers.IO).launch {
            /*val user = authViewModel.sendRequest(
                *//*binding.tvUsername.text.toString(),
                binding.tvPassword.text.toString()*//*
                "acharlota",
                "M9lbMdydMN"
            )*/
            val user = userApi.auth(
                RequestData(
                    "acharlota",
                    "M9lbMdydMN"
                )
            )
            runBlocking {
                binding.apply {
                    navigator().goToUserScreen(user.firstName, user.lastName, user.image)
                    Log.d("karamba", "${user.firstName}, ${user.lastName}, ${user.image}")
                }
            }
        }

    }

}