package android.maxim.retrofitauthentication

import android.maxim.myapplication.R
import android.maxim.retrofitauthentication.navigator.Navigator
import android.maxim.retrofitauthentication.ui.authscreen.AuthFragment
import android.maxim.retrofitauthentication.ui.userscreen.UserFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), Navigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, AuthFragment())
                .commit()
        }
    }

    override fun goToUserScreen(firstName: String, lastName: String, image: String) {
        launchFragment(UserFragment.userFragmentNewInstance(firstName, lastName, image))
    }

    override fun goToAuthScreen() {
        launchFragment(AuthFragment())
    }

    private fun launchFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}