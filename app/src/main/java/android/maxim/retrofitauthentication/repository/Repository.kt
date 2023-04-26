package android.maxim.retrofitauthentication.repository

import android.maxim.retrofitauthentication.model.RequestData
import android.maxim.retrofitauthentication.model.User
import android.maxim.retrofitauthentication.model.UserApi
import android.maxim.retrofitauthentication.ui.userscreen.UserFragmentViewModel
import android.util.Log
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository {

    lateinit var retrofit: Retrofit
    lateinit var userApi: UserApi

    var user: User? = null


    init {
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
    }

    suspend fun sendRequest(username: String, password: String) {
            user = userApi.auth(
                RequestData(
                    username,
                    password
                )
            )
            Log.d("karamba", "Repository.sendRequest " + user!!.firstName)

         /*CoroutineScope(Dispatchers.IO).async {
            user = userApi.auth(
                RequestData(
                    username,
                    password
                )
            )

             Log.d("karamba", "Repository.sendRequest " + user!!.firstName)

        }*/
        //Log.d("karamba", "Repository.sendRequest 2 " + user!!.firstName)
    }

}