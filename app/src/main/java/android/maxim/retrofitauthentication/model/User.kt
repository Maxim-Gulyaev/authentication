package android.maxim.retrofitauthentication.model

import com.google.gson.annotations.SerializedName

data class User (

    @SerializedName("id")
    val id: Int,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("token")
    val token: String

)
/*
class User {

    @SerializedName("id")
    val id: Int? = null
    @SerializedName("username")
    val username: String? = null
    @SerializedName("email")
    val email: String? = null
    @SerializedName("firstName")
    val firstName: String? = null
    @SerializedName("lastName")
    val lastName: String? = null
    @SerializedName("gender")
    val gender: String? = null
    @SerializedName("image")
    val image: String? = null
    @SerializedName("token")
    val token: String? = null

}*/
