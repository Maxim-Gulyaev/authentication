package android.maxim.retrofitauthentication.ui

import android.maxim.myapplication.databinding.FragmentUserBinding
import android.maxim.retrofitauthentication.navigator.navigator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso

class UserFragment: Fragment() {

    private lateinit var binding: FragmentUserBinding
    private var firstName = ""
    private var lastName = ""
    private var image = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firstName = arguments?.getString(FIRSTNAME).toString()
        lastName = arguments?.getString(LASTNAME).toString()
        image = arguments?.getString(IMAGE).toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserBinding.inflate(layoutInflater)

        binding.btnQuit.setOnClickListener { quit() }

        showUserData()

        return binding.root
    }

    private fun quit() {
        navigator().goToAuthScreen()
    }

    private fun showUserData() {
        binding.tvFirstName.text = firstName
        binding.tvLastName.text = lastName
        Picasso.get().load(image).into(binding.ivAvatar)
    }

    companion object {
        @JvmStatic
        private val FIRSTNAME = "FIRSTNAME"

        @JvmStatic
        private val LASTNAME = "LASTNAME"

        @JvmStatic
        private val IMAGE = "IMAGE"

        fun userFragmentNewInstance(
            firstName: String,
            lastName: String,
            image: String): UserFragment {

            val args = Bundle()
            args.putString(FIRSTNAME, firstName)
            args.putString(LASTNAME, lastName)
            args.putString(IMAGE, image)
            val fragment = UserFragment()
            fragment.arguments = args
            return fragment
        }
    }
}