package android.maxim.retrofitauthentication.model

import androidx.annotation.CheckResult
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("auth/login")
    //fun auth(@Body requestData: RequestData): Call<User>
    //suspend fun auth(@Body requestData: RequestData): Call<User>
    suspend fun auth(@Body requestData: RequestData): User


}