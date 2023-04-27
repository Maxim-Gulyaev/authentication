package android.maxim.retrofitauthentication.navigator

import androidx.fragment.app.Fragment

fun Fragment.navigator(): Navigator {
    return requireActivity() as Navigator
}

interface Navigator {

    fun goToUserScreen(firstName: String, lastName: String, image: String)

    fun goToAuthScreen()

}