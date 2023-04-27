package android.maxim.retrofitauthentication.model

import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("auth/login")
    suspend fun auth(@Body requestData: RequestData): User

}