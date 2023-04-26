package android.maxim.retrofitauthentication.ui.userscreen

import android.maxim.retrofitauthentication.model.User
import android.maxim.retrofitauthentication.repository.Repository
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserFragmentViewModel: ViewModel() {

    val userFragmentMutableLiveData = MutableLiveData<User>()
    private val repository = Repository()

    fun getLiveDataInstance(): LiveData<User> {
        return userFragmentMutableLiveData
    }

    fun getData() {
        userFragmentMutableLiveData.value = repository.user
        Log.d("karamba", "viewmodel.getData" + repository.user.toString())

    }

}