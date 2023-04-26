package android.maxim.retrofitauthentication.ui.authscreen

import android.maxim.retrofitauthentication.repository.Repository
import androidx.lifecycle.ViewModel

class AuthFragmentViewModel: ViewModel() {

    private val repository = Repository()
    val firstName = ""
    val lastName = ""

    /*suspend fun sendRequest(username: String, password: String) {
        repository.sendRequest(username, password)
    }*/
}